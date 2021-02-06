package jHealthUp_mini;

import java.util.Calendar;
import java.util.Scanner;


public class Person {

	
	//�̸�
	String name;
	//����
	int age;
	//�ֹε�Ϲ�ȣ
	//-����
	int[] identifier=new int[13];
	//����
	char gender;
	//¦���� ����, Ȧ���� ����
	
	//������
	String addr;
	
	
	//1�� ������ �������
		//1���� ������ ��õ
	Calendar start=Calendar.getInstance();
	Calendar temp=(Calendar) start.clone();//calnedar implements cloneable, serialization
	Calendar temp2=(Calendar) start.clone();//1���� �� �뵵
	//���Կ���(1�⸶�� ���̸� ������Ű�� ����)->�ǵ帱 �ʿ䰡 ����
	int signYr=start.get(Calendar.YEAR);
	//���Կ�
	int signMon=start.get(Calendar.MONTH)+1;//0~11
	//������
	int signDay=start.get(Calendar.DAY_OF_MONTH);
	//���Կ���
	int signDateTemp=start.get(Calendar.DAY_OF_WEEK)-1;//1~7:��~��->�迭�� �̿��ϱ� ���� -1�ϱ�!
	
	
	/*
	 * way 1 ���� �迭�� �����ΰ� �̸� ������ �ѱ��
	 * way 2 switch-case(�ð����⵵ ����� �ʿ� ���� ��(Ȯ�� �ʿ�))
	 */
	String[] sDay= {"SUN","MON","TUE","WED","THU","FRI","SAT"};
	String signDate=sDay[signDateTemp];
	
	public Diet d1=new Diet();
	public Food f1=new Food();

	
	
	//getter for check
	public String GetName()
	{
		return name;
	}
	public int GetAge()
	{
		return age;
	}
	public String GetAddr()
	{
		return addr;
	}
	public String[] GetIdentifier()
	{
		String[] id=new String[14];
		int i=0;
		
		while(i<6)
		{
			id[i]=Integer.toString(identifier[i]);
			i++;
		}
		id[i]="-";
		i++;
		while(i<14)
		{
			id[i]=Integer.toString(identifier[i-1]);
			i++;
		}
		
		return id;
	}
	public char GetGender()
	{
		if(identifier[6]%2==1)
		{
			gender='M';
		}
		else
		{
			gender='F';
		}
		return gender;
	}
	public String[] GetOriginDate()
	{
		String[] SignDate=new String[6];
		SignDate[0]=Integer.toString(signYr);
		SignDate[1]=SignDate[3]="-";
		SignDate[2]=Integer.toString(signMon);
		SignDate[4]=Integer.toString(signDay);
		SignDate[5]="("+signDate+")";
		return SignDate;
	}
	
	/*Update*/
	//���� ����(1�ϰ������� ������Ʈ)
	public void updateRedWeight()
	{
		String tmp;
		//�˶� or ��˶� Ȯ��
		(this).ReAlarm();
		if((((Calendar.getInstance().getTimeInMillis()-temp.getTimeInMillis())/1000)/(60*60*24))==1)
		{
			//1�� �������
			System.out.println("�� kg�� �����Ͽ����� �Է����ּ���(��: 1)");
			tmp=new Scanner(System.in).nextLine();
			this.f1.redWeight=Double.parseDouble(tmp);
			this.d1.weight-=this.f1.redWeight;//ü�� ����
			
		}
		else
		{
			System.out.println("���� ������Ʈ ���� �ʾҽ��ϴ�!(1�� �������� ������Ʈ���ּ���)");
		}
		System.out.println("���� ü��: "+this.d1.weight+"kg, ���� ü��(���� ���): "+this.f1.redWeight+" kg");
		//temp ����(���̸� �׻� �����ϸ鼭 ����)
		temp.add(temp.DATE, 1);
		
		
	}
	//1���� ������ ��õ(�Ĵ�, �)
	public void updateRecommendation()
	{
		ReAlarm();
		if((((Calendar.getInstance().getTimeInMillis()-temp2.getTimeInMillis())/1000)/(60*60*24))==7)
		{
			//7�� �������
			System.out.println("==[Update]�̹��� ��õ �Ĵ�==");
			this.f1.SetMenu();
			for(String i:this.f1.GetMenu())
			{
				System.out.println(i);
			}
			System.out.println();
			System.out.println("==[Update]�̹��� ��õ ��ƾ==");
			this.d1.SetRout();
			for(String i:this.d1.GetRout())
			{
				System.out.println(i);
			}
			System.out.println();
		}
		else
		{
			System.out.println("���� 1������ ������� �ʾҽ��ϴ�.");
			System.out.println();
			System.out.println("==[�̹���]�Ĵ� ==");
			this.f1.SetMenu();
			this.d1.SetRout();
			for(String i:this.f1.GetMenu())
			{
				System.out.println(i);
			}
			System.out.println();
			System.out.println("==[�̹���]��ƾ ==");
			for(String i:this.d1.GetRout())
			{
				System.out.println(i);
			}
			System.out.println();
		}
		//temp ����(���̸� �׻� �����ϸ鼭 ����)
		temp2.add(temp2.DATE, 7);
		
	}
	public void ReAlarm()
	{
		int AlarmCall=0;
		if(AlarmCall==0)
		{
			System.out.println("[��������!]");
		}
		else if(AlarmCall>0)
		{
			System.out.println("[�ٽþ˸�]");
		}
		AlarmCall++;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p=new Person();
		//Diet d=new Diet();
		//Food f=new Food();
		
		System.out.println("�̸��� �Է����ּ���");
		p.name=new Scanner(System.in).nextLine();
		
		System.out.println("���̸� �Է����ּ���");
		p.age=new Scanner(System.in).nextInt();
		
		System.out.println("�ֹε�Ϲ�ȣ�� �Է����ּ���(��:1234567890123)");
		String tmp=new Scanner(System.in).nextLine();
		for(int i=0;i<tmp.length();i++)
		{
			p.identifier[i]=tmp.charAt(i)-'0';
		}
		
		System.out.println("�������� �Է����ּ���");
		tmp=new Scanner(System.in).nextLine();
		p.addr=tmp;
		
		
		System.out.println("����(Ű)�� �Է����ּ���(����: cm)");
		tmp=new Scanner(System.in).nextLine();
		p.d1.height=Double.parseDouble(tmp);
		
		System.out.println("ü��(������)�� �Է����ּ���(����: kg)");
		tmp=new Scanner(System.in).nextLine();
		p.d1.weight=Double.parseDouble(tmp);
		System.out.println("[��������]�̸�: "+p.GetName()+", ����: "
				+ p.GetAge()+"��, ����: "+p.GetGender()+", �ּ�: "+p.GetAddr());
		System.out.println("�ֹε�Ϲ�ȣ: ");
		String[] iden=p.GetIdentifier();
		
		for(int i=0;i<iden.length;i++)
		{
			System.out.printf("%s",iden[i]);
		}
		System.out.println();
		System.out.println("������: ");
		String[] dOrigin=p.GetOriginDate();
		for(int i=0;i<dOrigin.length;i++)
		{
			System.out.printf("%s", dOrigin[i]);
		}
		System.out.println();
		/*update �ϸ鼭 �ڵ����� �Ĵ� �� ���� ä�߶��� �˷���*/
		//1�� ������ �������
		p.updateRedWeight();
		//1���� ������ ��õ
		p.updateRecommendation();
		
		
	}

}


