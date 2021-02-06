package jHealthUp_mini;

import java.util.Calendar;
import java.util.Scanner;


public class Person {

	
	//이름
	String name;
	//나이
	int age;
	//주민등록번호
	//-제외
	int[] identifier=new int[13];
	//성별
	char gender;
	//짝수는 여자, 홀수는 남자
	
	//거주지
	String addr;
	
	
	//1일 단위로 감량기록
		//1주일 단위로 추천
	Calendar start=Calendar.getInstance();
	Calendar temp=(Calendar) start.clone();//calnedar implements cloneable, serialization
	Calendar temp2=(Calendar) start.clone();//1주일 후 용도
	//가입연도(1년마다 나이를 증가시키기 위함)->건드릴 필요가 없음
	int signYr=start.get(Calendar.YEAR);
	//가입월
	int signMon=start.get(Calendar.MONTH)+1;//0~11
	//가입일
	int signDay=start.get(Calendar.DAY_OF_MONTH);
	//가입요일
	int signDateTemp=start.get(Calendar.DAY_OF_WEEK)-1;//1~7:일~토->배열을 이용하기 위해 -1하기!
	
	
	/*
	 * way 1 요일 배열을 만들어두고 이를 값으로 넘기기
	 * way 2 switch-case(시간복잡도 고려할 필요 있을 듯(확인 필요))
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
	//감량 무게(1일간격으로 업데이트)
	public void updateRedWeight()
	{
		String tmp;
		//알람 or 재알람 확인
		(this).ReAlarm();
		if((((Calendar.getInstance().getTimeInMillis()-temp.getTimeInMillis())/1000)/(60*60*24))==1)
		{
			//1일 경과마다
			System.out.println("몇 kg를 감량하였는지 입력해주세요(예: 1)");
			tmp=new Scanner(System.in).nextLine();
			this.f1.redWeight=Double.parseDouble(tmp);
			this.d1.weight-=this.f1.redWeight;//체중 갱신
			
		}
		else
		{
			System.out.println("아직 업데이트 되지 않았습니다!(1일 간격으로 업데이트해주세요)");
		}
		System.out.println("현재 체중: "+this.d1.weight+"kg, 감량 체중(전일 대비): "+this.f1.redWeight+" kg");
		//temp 갱신(차이를 항상 변경하면서 관찰)
		temp.add(temp.DATE, 1);
		
		
	}
	//1주일 단위로 추천(식단, 운동)
	public void updateRecommendation()
	{
		ReAlarm();
		if((((Calendar.getInstance().getTimeInMillis()-temp2.getTimeInMillis())/1000)/(60*60*24))==7)
		{
			//7일 경과마다
			System.out.println("==[Update]이번주 추천 식단==");
			this.f1.SetMenu();
			for(String i:this.f1.GetMenu())
			{
				System.out.println(i);
			}
			System.out.println();
			System.out.println("==[Update]이번주 추천 루틴==");
			this.d1.SetRout();
			for(String i:this.d1.GetRout())
			{
				System.out.println(i);
			}
			System.out.println();
		}
		else
		{
			System.out.println("아직 1주일이 경과되지 않았습니다.");
			System.out.println();
			System.out.println("==[이번주]식단 ==");
			this.f1.SetMenu();
			this.d1.SetRout();
			for(String i:this.f1.GetMenu())
			{
				System.out.println(i);
			}
			System.out.println();
			System.out.println("==[이번주]루틴 ==");
			for(String i:this.d1.GetRout())
			{
				System.out.println(i);
			}
			System.out.println();
		}
		//temp 갱신(차이를 항상 변경하면서 관찰)
		temp2.add(temp2.DATE, 7);
		
	}
	public void ReAlarm()
	{
		int AlarmCall=0;
		if(AlarmCall==0)
		{
			System.out.println("[따끈따끈!]");
		}
		else if(AlarmCall>0)
		{
			System.out.println("[다시알림]");
		}
		AlarmCall++;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p=new Person();
		//Diet d=new Diet();
		//Food f=new Food();
		
		System.out.println("이름을 입력해주세요");
		p.name=new Scanner(System.in).nextLine();
		
		System.out.println("나이를 입력해주세요");
		p.age=new Scanner(System.in).nextInt();
		
		System.out.println("주민등록번호를 입력해주세요(예:1234567890123)");
		String tmp=new Scanner(System.in).nextLine();
		for(int i=0;i<tmp.length();i++)
		{
			p.identifier[i]=tmp.charAt(i)-'0';
		}
		
		System.out.println("거주지를 입력해주세요");
		tmp=new Scanner(System.in).nextLine();
		p.addr=tmp;
		
		
		System.out.println("신장(키)을 입력해주세요(단위: cm)");
		tmp=new Scanner(System.in).nextLine();
		p.d1.height=Double.parseDouble(tmp);
		
		System.out.println("체중(몸무게)을 입력해주세요(단위: kg)");
		tmp=new Scanner(System.in).nextLine();
		p.d1.weight=Double.parseDouble(tmp);
		System.out.println("[개인정보]이름: "+p.GetName()+", 나이: "
				+ p.GetAge()+"세, 성별: "+p.GetGender()+", 주소: "+p.GetAddr()+" ,신장: "+
				p.d1.GetHeight()+" cm, 체중: "+p.d1.GetWeight()+" kg, BMI: "+p.d1.GetBmi()+"kg/m^2");
		System.out.println("주민등록번호: ");
		String[] iden=p.GetIdentifier();
		
		for(int i=0;i<iden.length;i++)
		{
			System.out.printf("%s",iden[i]);
		}
		System.out.println();
		System.out.println("가입일: ");
		String[] dOrigin=p.GetOriginDate();
		for(int i=0;i<dOrigin.length;i++)
		{
			System.out.printf("%s", dOrigin[i]);
		}
		System.out.println();
		/*update 하면서 자동으로 식단 및 현재 채중람량 알려줌*/
		//1일 단위로 감량기록
		p.updateRedWeight();
		//1주일 단위로 추천
		p.updateRecommendation();
		
		
	}

}


