package com.rhb.epg.repository;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.jdon.annotation.Component;
import com.jdon.annotation.Introduce;
import com.jdon.annotation.pointcut.Around;
import com.mongodb.BasicDBObject;
import com.mongodb.Bytes;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;
import com.rhb.epg.domain.Problem;
import com.rhb.epg.util.PojoMapper;

@Component
@Introduce("modelCache")
public class ProblemRepositoryImple implements ProblemRepository {
	private static final Mongo mg = createMongoInstance();
	private static final String DBName = "epg";
	private static final String CollectionName = "problems";

	private static Mongo createMongoInstance() {
		Mongo mg = null;
		try {
			mg =  new Mongo();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return mg;
    }
	
	private DB getDB(){
		return mg.getDB(DBName);
	}
	private DBCollection getCollection(){
		return getDB().getCollection(CollectionName);
	}
	
	private void save(Problem problem){
		System.out.println("ProblemRepositoryImple.save...");
		String json = null;
		json = PojoMapper.toJson(problem, true);
		
		if(json!=null){
			DBObject obj = (DBObject)JSON.parse(json);
			obj.put("_id", problem.getId());
			DB db = getDB();
			db.requestStart();
			DBCollection problems = db.getCollection(CollectionName);

			WriteResult result = problems.save(obj);
			System.out.println("save count:"+result.getN());  
	        if(result.getLastError().ok()){//获取上次操作结果是否有错误.  
	            System.out.println("save successed.");  
	        }else{  
	            System.out.println("save failed. " + result.getLastError().getErrorMessage());  
	        } 
			db.requestDone();				
		}else{
            System.out.println("save failed. Problem to json is null");  
		}
			
		System.out.println("---------");
	}
	
	@Override
	public Problem create(String id) {
		System.out.println("ProblemRepositoryImple.create...");
		Problem problem = (Problem)this.getProblem(id);
		if(problem == null){
			problem = new Problem();
			problem.setId(id);
			save(problem);
		}else{
			System.out.println("'" + id + "' has already exists!");			
		}
		return (Problem)this.getProblem(id);
	}

	@Override
	public void update(Problem problem) {
		System.out.println("ProblemRepositoryImple.update...");
		save(problem);
	}

	@Override
	public void delete(String id) {
		System.out.println("ProblemRepositoryImple.delete...");
		
		DB db = getDB();
		db.requestStart();
		DBCollection problems = db.getCollection(CollectionName);
		DBObject query = new BasicDBObject();
		query.put("_id", id);
		
		DBObject obj = problems.findOne(query);
		if(obj != null){
			WriteResult result = problems.remove(obj);
			System.out.println("save count:"+result.getN());  
	        if(result.getLastError().ok()){//获取上次操作结果是否有错误.  
	            System.out.println("delete successed.");  
	        }else{  
	            System.err.println("delete failed. " + result.getLastError().getErrorMessage());  
	        } 
		}
		db.requestDone();
	}

	@Around
	@Override
	public Problem getProblem(String id) {
		System.out.println("ProblemRepositoryImple.getProblem('"+id+"')");

		Problem problem = null;
		DB db = getDB();
		
		//db.requestStart();
		
		DBCollection problems = db.getCollection(CollectionName);
		DBObject query = new BasicDBObject();
		query.put("_id", id);
		
		DBObject obj = problems.findOne(query);
		if(obj != null){
			String json = JSON.serialize(obj);
			try {
				problem = (Problem)PojoMapper.fromJson(json, Problem.class);
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//db.requestDone();
		
		return problem;
	}

	@Override
	public List<Problem> getProblems() {
		System.out.println("ProblemRepositoryImple.getProblems...");
		List<Problem> list = new ArrayList();
		DBCollection problems = getCollection();
		System.out.println("There are " + problems.getCount() + " Problems to load....");

		BasicDBObject keys = new BasicDBObject();
		keys.put("id", 1);
		
		DBCursor cur = problems.find(new BasicDBObject(), keys).addOption(Bytes.QUERYOPTION_NOTIMEOUT);
		while(cur.hasNext()){
			DBObject obj = cur.next();
			String id = (String)obj.get("id");
			list.add(getProblem(id));		
		}
		cur.close();
		return list;
	}

}
