package jHealthUp_mini;

public class Diet {
	//����
	double height;
	//ü��
	double weight;
	//BMI
	double bmi=weight/((height*0.01)*(height*0.01));
	
	//���ƾ(1���� � ��õ)
	String[] routine=new String[7];
	
	String[] r_date= {"SUN","MON","TUE","WED","THU","FRI","SAT"};

	
	
	/*setter*/
	
	public void SetRout()
	{
		//���ƾ
		String[] ex= {"�ٳѱ� 1�ð�", "����Ŭ 1�ð�","�ȱ� 1�ð�","����� 1�ð�",
				"ȨƮ���̴� 30��","����Ʈ 100��","HILT 30��"};
		System.out.println("==������ � ��ƾ�Դϴ�==");
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
		//���ƾ
		return routine;
	}
	
}
