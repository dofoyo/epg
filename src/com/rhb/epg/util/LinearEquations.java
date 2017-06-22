package com.rhb.epg.util;

import java.util.List;

public class LinearEquations {

	private int factor;
	private double[][] parameters;
	private double[] values;
	
	private double[] x;
	private int n2; //记录换行的次数

	public LinearEquations(List<double[]> args){
		factor = args.size();	
		parameters = new double[factor+1][factor+1];
		values = new double[factor+1];
        x=new double[factor+1];
        for(int i=1;i<=factor;i++){
        	double[] dd = args.get(i-1);
        	for(int j=1;j<=factor;j++){
           		parameters[i][j]=dd[j-1];
        	}
       		values[i]= dd[factor];

        }
        //PrintA();

        Elimination();
        Back();
        //Print();
        Determinant();
	}
	
	public double[] result(){
		return x;
	}
	
    private void Elimination(){  //消元
		for(int k=1;k<=factor-1;k++)
		{
			Wrap(k);
			for(int i=k+1;i<=factor;i++)
			{
				double l=parameters[i][k]/parameters[k][k];
				parameters[i][k]=0.0;
				for(int j=k+1;j<=factor;j++)
					parameters[i][j]=parameters[i][j]-l*parameters[k][j];
				values[i]=values[i]-l*values[k];
			}
			//System.out.println("第"+k+"次消元后：");
			//PrintA();
		}
	}
    
    private void Back()//回代
    {
    	x[factor]=values[factor]/parameters[factor][factor];
    	for(int i=factor-1;i>=1;i--)
    		x[i]=(values[i]-jisuan(i))/parameters[i][i];
    }
    
    private double jisuan(int i){
    	double he=0.0;
    	for(int j=i+1;j<=factor;j++)
    		he=he+x[j]*parameters[i][j];
    	return he;
    }

    private void Wrap(int k){//换行
    	double max=Math.abs(parameters[k][k]);
    	int n1=k;                   //记住要交换的行
    	for(int i=k+1;i<=factor;i++)     //找到要交换的行
    	{
    		if(Math.abs(parameters[i][k])>max){
    			n1=i;
    			max=Math.abs(parameters[i][k]);
    		}
    	}
    	if(n1!=k)
    	{
    		n2++;
    	//System.out.println("当k="+k+"时,要交换的行是："+k+"和"+n1);
    	for(int j=k;j<=factor;j++)  //交换a的行
    	{
    		double x1;
    		x1=parameters[k][j];
    		parameters[k][j]=parameters[n1][j];
    		parameters[n1][j]=x1;
    	}
    	double b1;   //交换b的行
		b1=values[k];
		values[k]=values[n1];
		values[n1]=b1;
		//System.out.println("交换后：");
		//PrintA();
    	}
    }

    private void Determinant(){//求行列式
    	double DM=1.0;
    	for(int i=1;i<=factor;i++)
    	{
    		double a2=parameters[i][i];
    	    DM=DM*a2;
    	}
    	double n3=(double)n2;
    	DM=DM*Math.pow(-1.0, n3);
    	//System.out.println("该方程组的系数行列式：det A = "+DM);
    }

    private void PrintA(){//输出增广矩阵
    	System.out.println("增广矩阵为：");
    	for(int i=1;i<=factor;i++)
    	{
    		for(int j=1;j<=factor;j++)
    			System.out.print(parameters[i][j]+"    ");
    		System.out.print(values[i]+"    ");
    		System.out.print("\n");
    	}
    }
    private void Print(){//输出方程的根
    	System.out.println("方程组的根为：");
    	for(int i=1;i<=factor;i++)
    		System.out.println("x"+i+" = "+x[i]);
    }

}
