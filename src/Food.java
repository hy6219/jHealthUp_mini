package jHealthUp_mini;

public class Food {
	/*
	 * 모든 피험자에 대해서 공통적으로 제공되는 부분
	 * */
	
	//다이어트 모드 설정
	int mod=0;//0:닭가슴살 다이어트,1:디톡스다이어트, 2:1일 1식다이어트
	//식단 1주일 단위 추천
	//다이어트 모드에 의해서
	String[] menu=new String[7];
	//1일 단위 감량 체중
	double redWeight;
	String[] day= {"SUN","MON","TUE","WED","THU","FRI","SAT"};
	/*
	 * 모드에 따른 setter(다이어트모드)
	 */
	public void SetMenu()
	{
		String[] OneWk=new String[7];
		//닭가슴살 모드
		String[] chicken= {"아침: 요거트볼, 점심: 닭가슴살 샌드위치, 저녁: 현미밥+닭가슴살야채볶음",
				"아침: 케이준치킨샐러드, 점심: 달걀2알+아몬드브리즈, 저녁: 고구마1개+닭가슴살1/2",
				"아침: 요거트볼, 점심: 연어샐러드, 저녁: 닭가슴살야채볶음",
				"아침: 프로틴바1개+아몬드브리즈, 점심: 닭가슴살샐러드, 저녁: 낫또1개+고구마1개",
				"아침: 그린스무디1잔, 점심: 일반식, 저녁: 닭가슴살야채볶음",
				"아침: 귤3개, 점심: 일반식, 저녁: 현미밥+닭가슴살야채볶음",
				"아침: 스무디볼, 점심: 닭가슴살토마토수프(토마토수프), 저녁: 닭가슴살토마토수프(토마토수프)"};
		//디톡스 모드
		String[] detox= {"아침: 그린스무디, 점심: 레드스무디, 저녁: 현미밥+닭가슴살야채볶음",
				"아침: 그린스무디, 점심: 레몬스무디, 저녁: 현미밥+닭가슴살야채볶음",
				"아침: 그린스무디, 점심: 스무디볼, 저녁: 현미밥+닭가슴살야채볶음",
				"아침: 그린스무디, 점심: 프로틴쉐이크, 저녁: 현미밥+닭가슴살야채볶음",
				"아침: 그린스무디, 점심: abc디톡스주스, 저녁: 현미밥+닭가슴살야채볶음",
				"아침: 그린스무디, 점심: 레드스무디, 저녁: 현미밥+닭가슴살야채볶음",
				"아침: 스무디볼, 점심: 닭가슴살토마토수프(토마토수프), 저녁:닭가슴살토마토수프(토마토수프)"};
		//1일 1식 모드
		String[] oneMl= {"현미밥+닭가슴살야채볶음",
				"고구마1개+닭가슴살1/2",
				"닭가슴살야채볶음",
				"곤드레밥+가지볶음+연어1/2구이",
				"닭가슴살야채볶음",
				"닭가슴살토마토수프(토마토수프)",
				"닭가슴살토마토수프(토마토수프)"};
		switch(mod)
		{
		//닭가슴살 모드
		case 0:
			System.out.println("==닭가슴살 다이어트(1주일 식단)==");
			for(int i=0;i<7;i++)
			{
				OneWk[i]="("+day[i]+") "+chicken[(int)(Math.random()*7)];
			}
			break;
			//디톡스 모드
		case 1:
			System.out.println("==디톡스 다이어트(1주일 식단)==");
			for(int i=0;i<7;i++)
			{
				OneWk[i]="("+day[i]+") "+detox[(int)(Math.random()*7)];
			}
			break;
			//1일 1식 모드
		case 2:
			System.out.println("==1일 1식(1주일 식단)==");
			for(int i=0;i<7;i++)
			{
				OneWk[i]="("+day[i]+") "+oneMl[(int)(Math.random()*7)];
			}
			break;
		default:
			System.out.println("아직 다른 다이어트 식단은 준비중이오니, 잠시만 기다려주세요!");
			System.out.println("요청 식단은 1588-xxxx로 전화해주세요!");
			break;
		}
		menu=OneWk;
	}
	/*
	 * getter
	 */
	public String[] GetMenu()
	{
		return menu;
	}
	public double GetRedWeight()
	{
		return redWeight;
	}
	public String GetDietMode()
	{
		String res="";
		if(mod<0 || mod>2)
		{
			res="ERR";
		}
		else if(mod==0)
		{
			res="닭가슴살 다이어트";
		}
		else if(mod==1)
		{
			res="디톡스 다이어트";
		}
		else if(mod==2)
		{
			res="1일1식 다이어트";
		}
		return res;
	}
	
}
