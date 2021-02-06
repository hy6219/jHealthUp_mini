package jHealthUp_mini;

public class Diet {
	//신장
	double height;
	//체중
	double weight;
	//BMI
	double bmi=weight/((height*0.01)*(height*0.01));
	
	//운동루틴(1주일 운동 추천)
	String[] routine=new String[7];
	
	String[] r_date= {"SUN","MON","TUE","WED","THU","FRI","SAT"};

	
	
	/*setter*/
	
	public void SetRout()
	{
		//운동루틴
		String[] ex= {"줄넘기 1시간", "사이클 1시간","걷기 1시간","유산소 1시간",
				"홈트레이닝 30분","스쿼트 100개","HILT 30분"};
		System.out.println("==일주일 운동 루틴입니다==");
		for(int i=0;i<routine.length;i++)
		{
			routine[i]="("+r_date[i]+")"+ex[(int)(Math.random()*7)];
		}
	}
	/*getter*/
	public double GetHeight()
	{
		return height;
	}
	public double GetWeight()
	{
		return weight;
	}
	public double GetBmi()
	{
		return bmi;
	}
	public String[] GetRout()
	{
		//운동루틴
		return routine;
	}
	
}
