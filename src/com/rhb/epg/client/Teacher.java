package com.rhb.epg.client;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.jdon.controller.AppUtil;
import com.rhb.epg.service.ProblemCommandService;
import com.rhb.epg.service.ProblemQueryService;

public class Teacher {
	static final AppUtil au = new AppUtil();
	static final ProblemCommandService ps = (ProblemCommandService)au.getComponentInstance("problemCommandService");
	static final ProblemQueryService pq = (ProblemQueryService)au.getComponentInstance("problemQueryService");

	@Test
	public void delete(){
		//ps.delete("0006");
		try {
			Thread.sleep(3000);  //让异步的event执行完
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> ss = pq.getProblems();
		for(String s : ss){
			System.out.println(s);
		}
	}
	/*
	@Test
	public void create0057(){
		String id = "0057";
		int level = 1;
		Set tags = new HashSet();
		tags.add("最优化");
		Map<String,String> templates = new HashMap();
		templates.put("dragon2_32","数学老师家有7把椅子，请油漆师傅来刷油漆。每把椅子要刷二次，刷一次3分钟，并且，第一次刷完后要等18分钟后油漆干了才能刷第二次。请问刷完7把椅子最少要几分钟？");
		String define = "";
		String matrix = "1,42";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0056(){
		String id = "0056";
		int level = 1;
		Set tags = new HashSet();
		tags.add("最优化");
		Map<String,String> templates = new HashMap();
		templates.put("dragon2_32","小强、小新、小贝三位小朋友同时到学校卫生室等候医生的治疗。小强打针需要5分钟，小新包纱布需要3分钟，小贝点眼药水需要1分钟。卫生室只有一位医生。问医生如何安排着三位小朋友的顺序，才能使三位小朋友留在卫生室的时间和最短？最短的时间是多少？");
		String define = "";
		String matrix = "1,14";
		ps.create(id, level, tags, templates, define, matrix);
	}
	
	
	@Test
	public void create0055(){
		String id = "0055";
		int level = 0;
		Set tags = new HashSet();
		tags.add("最优化");
		Map<String,String> templates = new HashMap();
		templates.put("dragon2_32","星期天，小明家来了几个妈妈的同时，妈妈叫小明给客人烧水沏茶。小明开始做事：洗水壶用1分钟，烧开水用8分钟，洗茶杯茶壶用3分钟，准备茶叶用2分钟，沏茶用1分钟。计算一下，小明花多长时间才能尽快让客人喝上茶？");
		String define = "";
		String matrix = "1,10";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0054(){
		String id = "0054";
		int level = 1;
		Set tags = new HashSet();
		tags.add("和差");
		Map<String,String> templates = new HashMap();
		templates.put("dragon2_29","小贝从家到学校跑步一个来回要12分钟。如果去的时候步行，回来的时候跑步，一共需要18分钟。那么，小贝来回都步行需要多少分钟？");
		String define = "";
		String matrix = "1,24";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0053(){
		String id = "0053";
		int level = 2;
		Set tags = new HashSet();
		tags.add("时间");
		tags.add("周期");
		Map<String,String> templates = new HashMap();
		templates.put("dragon2_29","今天是15号，早上雨还在不停地下，妈妈对小兰说：“兰兰，考考你，今天下雨，再过72小时天才会晴，那么17号是晴还是雨？”");
		String define = "";
		String matrix = "1,18";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0052(){
		String id = "0052";
		int level = 1;
		Set tags = new HashSet();
		tags.add("时间");
		tags.add("周期");
		Map<String,String> templates = new HashMap();
		templates.put("dragon2_29","现在是上午10点，再过60小时，太阳会出来吗？");
		String define = "";
		String matrix = "1,22";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	
	@Test
	public void create0051(){
		String id = "0051";
		int level = 2;
		Set tags = new HashSet();
		tags.add("年龄");
		Map<String,String> templates = new HashMap();
		templates.put("dragon1_52","女儿今年12岁，妈妈今年36岁。几年前，妈妈的年龄是女儿的4倍？");
		String define = "";
		String matrix = "1,15";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0050(){
		String id = "0050";
		int level = 2;
		Set tags = new HashSet();
		tags.add("年龄");
		Map<String,String> templates = new HashMap();
		templates.put("dragon1_52","儿子今年2岁，爸爸今年32岁，今年后，爸爸的年龄是儿子的7倍？");
		String define = "";
		String matrix = "1,3";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0049(){
		String id = "0049";
		int level = 1;
		Set tags = new HashSet();
		tags.add("年龄");
		Map<String,String> templates = new HashMap();
		templates.put("dragon1_52","小刚今年18岁，比小明大6岁，那么，再过多少年两人的年龄之和是60岁？");
		String define = "";
		String matrix = "1,15";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0048(){
		String id = "0048";
		int level = 1;
		Set tags = new HashSet();
		tags.add("年龄");
		Map<String,String> templates = new HashMap();
		templates.put("dragon1_52","今年小红3岁，小贝9岁，当两人的年龄之和是30岁时，小红和小贝各是多少岁？");
		String define = "";
		String matrix = "1,0,12;0,1,18";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0047(){
		String id = "0047";
		int level = 1;
		Set tags = new HashSet();
		tags.add("年龄");
		Map<String,String> templates = new HashMap();
		templates.put("dragon1_52","哥哥今年9岁，弟弟今年6岁，多少年后两人的年龄之和是31岁？");
		String define = "";
		String matrix = "1,31";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0046(){
		String id = "0046";
		int level = 1;
		Set tags = new HashSet();
		tags.add("年龄");
		Map<String,String> templates = new HashMap();
		templates.put("dragon1_52","小华今年6岁，两年前妈妈的年龄是小华的7倍，问妈妈今年多少岁？");
		String define = "";
		String matrix = "1,30";
		ps.create(id, level, tags, templates, define, matrix);
	}
	
	@Test
	public void create0045(){
		String id = "0045";
		int level = 2;
		Set tags = new HashSet();
		tags.add("年龄");
		Map<String,String> templates = new HashMap();
		templates.put("dragon1_49","爷爷今年70岁，大孙子20岁，二孙子15岁，三孙子才5岁。多少年后，三个孙子的年龄之和与爷爷那个时候的年龄相等？");
		String define = "";
		String matrix = "1,15";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0044(){
		String id = "0044";
		int level = 1;
		Set tags = new HashSet();
		tags.add("年龄");
		Map<String,String> templates = new HashMap();
		templates.put("dragon1_49","姐姐今年12岁，姐姐3年前的年龄与妹妹2年后的年龄相等，妹妹今年多少岁？");
		String define = "";
		String matrix = "1,7";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0043(){
		String id = "0043";
		int level = 1;
		Set tags = new HashSet();
		tags.add("年龄");
		Map<String,String> templates = new HashMap();
		templates.put("dragon1_49","小贝今年10岁，8年后的年龄与哥哥今年的年龄相等，哥哥今年多少岁？");
		String define = "";
		String matrix = "1,8";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0042(){
		String id = "0042";
		int level = 0;
		Set tags = new HashSet();
		tags.add("年龄");
		Map<String,String> templates = new HashMap();
		templates.put("dragon1_48","小红今年10岁，比爸爸小26岁。7年前，爸爸比小红大多少岁？5年后爸爸多少岁？");
		String define = "";
		String matrix = "1,26";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0041(){
		String id = "0041";
		int level = 0;
		Set tags = new HashSet();
		tags.add("年龄");
		Map<String,String> templates = new HashMap();
		templates.put("dragon1_48","爸爸今年42岁，儿子今年14岁。6年前，儿子比爸爸小多少岁？10年后，爸爸比儿子大多少岁？");
		String define = "";
		String matrix = "1,28";
		ps.create(id, level, tags, templates, define, matrix);
	}

	@Test
	public void create0040(){
		String id = "0040";
		int level = 2;
		Set tags = new HashSet();
		tags.add("间隔(植树)");
		Map<String,String> templates = new HashMap();
		templates.put("dragon1_45","一根钢管锯成5段，要付工人锯工费12元。如果要把这根钢管锯成8段，要付工费多少钱？");
		String define = "";
		String matrix = "1,21";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0039(){
		String id = "0039";
		int level = 1;
		Set tags = new HashSet();
		tags.add("间隔(植树)");
		Map<String,String> templates = new HashMap();
		templates.put("dragon1_45","时钟4点钟敲4下，6秒钟敲完。那么8点钟敲8下，需要多少秒钟？");
		String define = "";
		String matrix = "1,14";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0038(){
		String id = "0038";
		int level = 1;
		Set tags = new HashSet();
		tags.add("间隔(植树)");
		Map<String,String> templates = new HashMap();
		templates.put("dragon1_45","9个男生围成一个圆形大圈玩“丢手帕”游戏，每两个男生之间安排进去2名女生。问一共有多少女生参加这个游戏？");
		String define = "";
		String matrix = "1,18";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0037(){
		String id = "0037";
		int level = 1;
		Set tags = new HashSet();
		tags.add("间隔(植树)");
		Map<String,String> templates = new HashMap();
		templates.put("dragon1_44","校门口摆了一排兰花，一共10盆。再在每两盆兰花中间摆3盆菊花，一共摆了多少盆菊花？");
		String define = "";
		String matrix = "1,27";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0036(){
		String id = "0036";
		int level = 0;
		Set tags = new HashSet();
		tags.add("间隔(植树)");
		Map<String,String> templates = new HashMap();
		templates.put("dragon1_44","把一根粗细均匀的木头锯成8段，要锯几次？如果每锯一次要2分钟，一共要锯几分钟？");
		String define = "";
		String matrix = "1,0,7;0,1,14";
		ps.create(id, level, tags, templates, define, matrix);
	}
	
	@Test
	public void create0035(){
		String id = "0035";
		int level = 2;
		Set tags = new HashSet();
		tags.add("间隔(植树)");
		Map<String,String> templates = new HashMap();
		templates.put("dragon1_40","贝贝和优优同住一栋楼，贝贝住六楼，优优住三楼。贝贝说：“我从底楼到家所走的楼梯数是优优从底楼到家走的楼梯数的2倍。”贝贝说的对吗？为什么？");
		String define = "";
		String matrix = "1,4";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0034(){
		String id = "0034";
		int level = 1;
		Set tags = new HashSet();
		tags.add("间隔(植树)");
		Map<String,String> templates = new HashMap();
		templates.put("dragon1_40","两根同样长的绳子重叠，被剪3次后，平均每段长2米，你知道这两根绳子的总长是多少米吗？");
		String define = "";
		String matrix = "1,16";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0033(){
		String id = "0033";
		int level = 1;
		Set tags = new HashSet();
		tags.add("间隔(植树)");
		Map<String,String> templates = new HashMap();
		templates.put("dragon1_40","王师傅家住六楼，他从一楼到三楼要走40级楼梯，那么他从一楼到家要走多少级楼梯？");
		String define = "";
		String matrix = "1,100";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0032(){
		String id = "0032";
		int level = 0;
		Set tags = new HashSet();
		tags.add("间隔(植树)");
		Map<String,String> templates = new HashMap();
		templates.put("dragon1_39","一根绳子剪了2次后，平均每段长5厘米，这根绳子原来长多少厘米？");
		String define = "";
		String matrix = "1,15";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0031(){
		String id = "0031";
		int level = 0;
		Set tags = new HashSet();
		tags.add("间隔(植树)");
		Map<String,String> templates = new HashMap();
		templates.put("dragon1_39","一根49米长的电线，剪了6次，平均每段长多少米？");
		String define = "";
		String matrix = "1,7";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0030(){
		String id = "0030";
		int level = 0;
		Set tags = new HashSet();
		tags.add("间隔(植树)");
		Map<String,String> templates = new HashMap();
		templates.put("dragon1_39","一根钢管长27米，把它锯成3米长的小段，可以锯成多少段？要锯几次？");
		String define = "";
		String matrix = "1,0,9;0,1,8";
		ps.create(id, level, tags, templates, define, matrix);
	}

	@Test
	public void create0029(){
		String id = "0029";
		int level = 2;
		Set tags = new HashSet();
		tags.add("移多补少");
		Map<String,String> templates = new HashMap();
		templates.put("dragon1_35","书架的上层有25本书，下层有27本书，爸爸又买回10本书，怎样放才能使书架上、下两层的书同样多？");
		String define = "";
		String matrix = "1,0,4;0,1,6";
		ps.create(id, level, tags, templates, define, matrix);
	}
	
	@Test
	public void create0028(){
		String id = "0028";
		int level = 1;
		Set tags = new HashSet();
		tags.add("移多补少");
		Map<String,String> templates = new HashMap();
		templates.put("dragon1_35","乐乐和笑笑一起画小猫，乐乐画了2张纸，每张纸上画了4只小猫；笑笑画了3张纸，每张纸上画了6只小猫，笑笑要给乐乐几只小猫，两人的小猫一样多？");
		String define = "";
		String matrix = "1,5";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0027(){
		String id = "0027";
		int level = 1;
		Set tags = new HashSet();
		tags.add("移多补少");
		Map<String,String> templates = new HashMap();
		templates.put("dragon1_35","甲、乙两筐各有西瓜20个，从甲筐取几个放入乙筐后，乙筐就比甲筐多8个，甲筐现在有多少个西瓜？");
		String define = "";
		String matrix = "1,16";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0026(){
		String id = "0026";
		int level = 0;
		Set tags = new HashSet();
		tags.add("移多补少");
		Map<String,String> templates = new HashMap();
		templates.put("dragon1_35","小英做了15朵纸花，她给小兰3朵后，两人纸花的一样多，小兰原来做了多少朵？");
		String define = "";
		String matrix = "1,9";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0025(){
		String id = "0025";
		int level = 0;
		Set tags = new HashSet();
		tags.add("移多补少");
		Map<String,String> templates = new HashMap();
		templates.put("dragon1_34","两篮鸡蛋，第一蓝比第二蓝多16个，从第一蓝拿出几个放进第二蓝，两蓝鸡蛋的个数一样多？");
		String define = "";
		String matrix = "1,8";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0024(){
		String id = "0024";
		int level = 0;
		Set tags = new HashSet();
		tags.add("移多补少");
		Map<String,String> templates = new HashMap();
		templates.put("dragon1_34","小华有10张画，小红有4张画，小华给小红多少张画后，他俩的画一样多？");
		String define = "";
		String matrix = "1,3";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0023(){
		String id = "0023";
		int level = 2;
		Set tags = new HashSet();
		tags.add("加法原理");
		tags.add("乘法原理");
		Map<String,String> templates = new HashMap();
		templates.put("asw2_123","从甲地到乙地有4条路可走，从乙地到丙地有2条路可走，从甲地到丙地有3条路可走。从甲地到丙地共有多少走法？");
		String define = "";
		String matrix = "1,11";
		ps.create(id, level, tags, templates, define, matrix);
	}
	
	
	@Test
	public void create0022(){
		String id = "0022";
		int level = 1;
		Set tags = new HashSet();
		tags.add("组合");
		Map<String,String> templates = new HashMap();
		templates.put("asw2_121","七个点能组成多少个线段？");
		String define = "";
		String matrix = "1,21";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0021(){
		String id = "0021";
		int level = 1;
		Set tags = new HashSet();
		tags.add("排列");
		Map<String,String> templates = new HashMap();
		templates.put("asw2_120","4名同学到照相馆照相。他们要排成一排，问共有多少种不同的排法？");
		String define = "";
		String matrix = "1,24";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0020(){
		String id = "0020";
		int level = 2;
		Set tags = new HashSet();
		tags.add("加法原理");
		tags.add("乘法原理");
		Map<String,String> templates = new HashMap();
		templates.put("asw2_117","小明和小王从北京出发锡先到天津看海，然后再到上海东方明珠塔参观。从北京到天津可以做火车或汽车，坐火车4个车次，坐汽车有3个车次。从天津到上海可以坐火车、汽车、轮船或飞机，火车有3个车次，汽车有5个车次，轮船有4个班次，飞机又2个班次。问小明和小王从北京到上海旅游一共有多少种走法？");
		String define = "";
		String matrix = "1,98";
		ps.create(id, level, tags, templates, define, matrix);
	}
	
	@Test
	public void create0019(){
		String id = "0019";
		int level = 4;
		Set tags = new HashSet();
		tags.add("鸡兔同笼");
		Map<String,String> templates = new HashMap();
		templates.put("asw176","有两次自然测验。第一次24道题，答对1题得5分，答错或不答1题扣1分；第二次15道题，答对1题8分，答错或不答1题扣2分。小明两次测验共答对30题，但第一次测验得分比第二次测验得分多10分，问小明两次测验各得多少分？");
		String define = "";
		String matrix = "1,0,90;0,1,80";
		ps.create(id, level, tags, templates, define, matrix);
	}
	
	@Test
	public void create0018(){
		String id = "0018";
		int level = 2;
		Set tags = new HashSet();
		tags.add("鸡兔同笼");
		Map<String,String> templates = new HashMap();
		templates.put("asw176","100个和尚140个馍，大和尚1人分3个馍，小和尚1个人1个馍，问大、小和尚各有多少人？");
		String define = "";
		String matrix = "1,0,20;0,1,80";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	public void create0017(){
		String id = "0017";
		int level = 2;
		Set tags = new HashSet();
		tags.add("鸡兔同笼");
		Map<String,String> templates = new HashMap();
		templates.put("asw176","鸡、兔共笼，鸡比兔多26只，共274只脚，问鸡、兔各几只？");
		String define = "";
		String matrix = "1,0,63;0,1,37";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	public void create0016(){
		String id = "0016";
		int level = 2;
		Set tags = new HashSet();
		tags.add("鸡兔同笼");
		Map<String,String> templates = new HashMap();
		templates.put("asw172","蜘蛛有8条腿，蜻蜓有6条腿和2对翅膀，蝉有6条腿和1对翅膀。现在有蜘蛛、蜻蜓和蝉共16只，110条腿和14对翅膀，每种昆虫各多少只？");
		String define = "";
		String matrix = "1,0,0,4;0,1,0,5;0,0,1,7";
		ps.create(id, level, tags, templates, define, matrix);
	}
	
	public void create0015(){
		String id = "0015";
		int level = 4;
		Set tags = new HashSet();
		tags.add("鸡兔同笼");
		Map<String,String> templates = new HashMap();
		templates.put("asw171","某旅游景点有儿童票、成人票和团体票三种规格的门票。儿童票的价格为30元/人，成人票的价格为40元/人，团体票的价格为32元/人。一个由8个家庭组成的旅游团（每个家庭要么二个大人，要么二个大人带一个小孩）来这个景点旅游，如果他们买团体票可以比他们各自买票要少花120元。这个旅游团一共有多少人？");
		String define = "";
		String matrix = "1,0,4;0,1,16";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	public void create0014(){
		String id = "0014";
		int level = 2;
		Set tags = new HashSet();
		tags.add("鸡兔同笼");
		Map<String,String> templates = new HashMap();
		templates.put("asw170","从前有座山，山里有座庙，庙里有许多和尚。他们在干什么呢？他们在挑水。每2个小和尚用一根扁担和一个水桶抬水；每一个大和尚用一根扁担和二个水桶挑水。他们共用了38根扁担和58个桶，请问这个庙里有多少个小和尚，有多少个大和尚？");
		String define = "";
		String matrix = "1,0,20;0,1,36";
		ps.create(id, level, tags, templates, define, matrix);
	}

	public void create0013(){
		String id = "0013";
		int level = 3;
		Set tags = new HashSet();
		tags.add("间隔");
		Map<String,String> templates = new HashMap();
		templates.put("asw167","国庆节北京市参加游行的总人数有60000人，这些人平均分成25阵队，每阵队以12人为一排列队前进，排与排之间的距离为1米，阵队与阵队之间的距离是4米。问游行队伍全长有多少米？");
		String define = "";
		String matrix = "1,5071";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	
	public void create0012(){
		String id = "0012";
		int level = 4;
		Set tags = new HashSet();
		tags.add("年龄");
		tags.add("和差");
		Map<String,String> templates = new HashMap();
		templates.put("asw165","全家4口人，父亲比母亲大3岁，姐姐比弟弟大2岁。4年前他们全家的年龄和为58岁，而现在是73岁。问现在每个人的年龄各是多少？");
		String define = "";
		String matrix = "1,0,20;0,1,35";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0011(){
		String id = "0011";
		int level = 2;
		Set tags = new HashSet();
		tags.add("年龄");
		tags.add("和差");
		Map<String,String> templates = new HashMap();
		templates.put("asw165","甲对乙说：“当我的岁数是你现在的岁数的时候，你才5岁。” 乙对甲说：“当我的岁数是你现在的岁数的时候，你将50岁。” 问甲、乙二人现在各多少岁？");
		String define = "";
		String matrix = "1,0,20;0,1,35";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0010(){
		String id = "0010";
		int level = 1;
		Set tags = new HashSet();
		tags.add("年龄");
		tags.add("和差");
		Map<String,String> templates = new HashMap();
		templates.put("asw165","今年爷爷78岁，3个孙子的年龄分别是27岁、23岁和16岁，进过几年后，爷爷的年龄等于3各孙子的年龄和？");
		String define = "";
		String matrix = "1,6";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0009(){
		String id = "0009";
		int level = 4;
		Set tags = new HashSet();
		tags.add("差倍");
		Map<String,String> templates = new HashMap();
		templates.put("asw164","学校计划栽种杨树、柳树、槐树共200棵，当种了一半的杨树和10棵柳树后，又临时运来了6棵槐树，这时剩下的3种树的棵树恰好相等，问原计划要栽种这3种树各多少棵？");
		String define = "";
		String matrix = "1,1,1,200;1,-2,0,20;1,0,-2,12";
		ps.create(id, level, tags, templates, define, matrix);
	}
	
	
	@Test
	public void create0008(){
		String id = "0008";
		int level = 3;
		Set tags = new HashSet();
		tags.add("和");
		Map<String,String> templates = new HashMap();
		templates.put("asw164","在一次期中考试中，小强的英语和数学成绩之和是194分，数学和语文成绩之和是186分，语文和英语成绩之和是180分，那么，小强的英语、数学和语文成绩各是多少？");
		String define = "";
		String matrix = "1,1,0,194;0,1,1,186;1,0,1,180";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0007(){
		String id = "0007";
		int level = 2;
		Set tags = new HashSet();
		tags.add("和差");
		Map<String,String> templates = new HashMap();
		templates.put("asw163","姐姐做自然科学练习，比妹妹做算术练习多用了48分钟，比妹妹做英语练习多用了42分钟。妹妹做算术、英语两门练习共用了44分钟，那么妹妹做英语练习用了多少分钟？");
		String define = "";
		String matrix = "1,1,44;1,-1,6";
		ps.create(id, level, tags, templates, define, matrix);
	}

	@Test
	public void create0006(){
		String id = "0006";
		int level = 1;
		Set tags = new HashSet();
		tags.add("间隔/植树");
		Map<String,String> templates = new HashMap();
		templates.put("asw163","把50枚黑棋子排列在正五边形的5条边上，每条边上的黑棋子个数相等，且每个角上有一枚。然后在所有相邻的两枚黑棋子间放两枚白棋子，问每条边上的白棋子有多少枚？");
		String define = "";
		String matrix = "1,20";
		ps.create(id, level, tags, templates, define, matrix);
	}
	
	@Test
	public void create0005(){
		String id = "0005";
		int level = 1;
		Set tags = new HashSet();
		tags.add("间隔/植树");
		Map<String,String> templates = new HashMap();
		templates.put("asw162","在学校的一条小路的一侧植树，每个5米种一颗，共种了21颗，这条路多长？后来小路又加长了30米，还是每隔5米种一颗树，一共补种多少棵树？");
		String define = "";
		String matrix = "1,0,100;0,1,6";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0004(){
		String id = "0004";
		int level = 3;
		Set tags = new HashSet();
		tags.add("年龄");
		Map<String,String> templates = new HashMap();
		templates.put("asw161","甲对乙说：”我在你这么大岁数的时候，你的岁数是我今年岁数的一半。“ 乙对甲说：”我到你这么大岁数的时候，你的岁数是我今年岁数的2倍减7。“ 问甲、乙二人现在各多少岁？");
		String define = "";
		String matrix = "3,-4,0;1,-2,-14";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	public void create0003(){
		String id = "0003";
		int level = 3;
		Set tags = new HashSet();
		tags.add("和差");
		Map<String,String> templates = new HashMap();
		templates.put("asw161","4个人年龄之和是87岁，年龄最小的一个12岁，他与年龄最大的人年龄之和比另外两个人年龄之和大7岁，那么，这4个人中年龄最大的一个年龄是多少？");
		String define = "";
		String matrix = "1,1,75;1,-1,-5";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	
	@Test
	public void create0002(){
		String id = "0002";
		int level = 3;
		Set tags = new HashSet();
		tags.add("和倍");
		tags.add("差倍");		
		Map<String,String> templates = new HashMap();
		templates.put("asw161","小新用20元钱买了5支圆珠笔和12本练习本，剩下的钱若买一支圆珠笔少4角，若买一本练习本少6角，问圆珠笔和练习本的价钱各是多少？");
		String define = "";
		String matrix = "5,12,19.4;10,-10,-2";
		ps.create(id, level, tags, templates, define, matrix);
	}

	
	@Test
	public void create0001(){
		String id = "0001";
		int level = 3;
		Set tags = new HashSet();
		tags.add("差倍");
		Map<String,String> templates = new HashMap();
		templates.put("asw160","某校原来参加室外活动的人数比室内活动的人数多#<a>人，现在把室内活动的#<b>人改为室外活动，这样室外活动的人数正好是室内活动人数的#<c>倍，参加室内室外活动的一共有多少人？");
		String define = "#<c>=5,#<b>=50,#<a>=480";
		String matrix = "1,-5,-300;1,-1,480";
		ps.create(id, level, tags, templates, define, matrix);
	}
	*/
}
