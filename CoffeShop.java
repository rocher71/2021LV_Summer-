import java.util.Scanner;
import java.util.Vector;

class Beverage
{
	String name = "";
	String liquid = "";
	String ingred1 = "";
	String ingred2 = "";
	String fin = "";
	
	
	Beverage(String _name, String _liquid, String _ingred1, String _ingred2, String _fin)
	{
		name = _name;
		liquid = _liquid;
		ingred1 = _ingred1;
		ingred2 = _ingred2;
		fin = _fin;
	}
}





public class CoffeShop {
	
	static Vector<Beverage> Menu = new Vector<>();
	
	static void print(int idx)
	{
		System.out.println(Menu.get(idx).liquid + "을(를) 넣는다");
		System.out.println(Menu.get(idx).ingred1 + "을(를) 넣는다");
		
		if(!Menu.get(idx).ingred2.equals("")) //ingred2 가 비어있지 않으면
		{
			System.out.println(Menu.get(idx).ingred2 + "을(를) 넣는다");
		}
		
		if(!Menu.get(idx).fin.equals("")) //ingred2 가 비어있지 않으면
		{
			System.out.println(Menu.get(idx).fin);
		}
		
	}
	
	public static void main(String[] args) {
		

		String order = "";
	
		Beverage hotAme = new Beverage("아메리카노(hot)", "물", "에스프레소", "", "");
		Beverage iceAme = new Beverage("아메리카노(ice)", "물", "에스프레소", "얼음", "");
		Beverage hotLatte = new Beverage("카페라떼(hot)", "우유", "에스프레소", "", "");
		Beverage iceLatte = new Beverage("카페라떼(ice)", "우유", "에스프레소", "얼음", "");
		Beverage hotVanLatte = new Beverage("바닐라라떼(hot)", "우유", "에스프레소", "바닐라 시럽", "");
		Beverage iceVanLatte = new Beverage("바닐라라떼(ice)", "우유", "에스프레소", "바닐라 시럽", "얼음을 넣는다");
		Beverage strSmoothie = new Beverage("딸기 스무디", "우유", "딸기", "", "믹서기를 이용해 섞는다");
		Beverage yogSmoothie = new Beverage("요거트 스무디", "우유", "요거트", "", "믹서기를 이용해 섞는다");
		Beverage iceTea = new Beverage("아이스티", "물", "아이스티 분말", "얼음", "");
		
		//Vector<Beverage> Menu = new Vector<>();
		
		Menu.add(iceAme);
		Menu.add(hotAme);
		Menu.add(iceLatte);
		Menu.add(hotLatte);
		Menu.add(iceVanLatte);
		Menu.add(hotVanLatte);
		Menu.add(strSmoothie);
		Menu.add(yogSmoothie);
		Menu.add(iceTea);
		
		
		System.out.println("메뉴판\n");
		
		for(Beverage i : Menu)
		{
			System.out.println(i.name);
		}
		
		
		Scanner sc = new Scanner(System.in);
		order = sc.nextLine();
		String[] orderSplit = order.split(" ");
		
		String orderMenuStr = "";
		String cmd = "";
		
		if(orderSplit.length == 3)
		{
			orderMenuStr = orderSplit[0] + orderSplit[1];
			cmd = orderSplit[2];
		}
		else if(orderSplit.length == 2)
		{
			orderMenuStr = orderSplit[0];
			cmd = orderSplit[1];
		}
		
		
		int _idx = -1;
		
		for(int i=0; i<7; i++)
		{
			if(orderMenuStr.equals(Menu.get(i).name))
			{
				_idx = i;
			}
		}
		
		
		if(cmd.equals("내놔!")) //주문을 하는 경우
		{
			System.out.println(orderMenuStr);
			
		
			//int idx = Menu.indexOf(orderMenuStr);
			System.out.println(_idx);
			print(_idx);
			
		}
		else // 문의를 하는 경우 
		{
			if(order.equals("우유가 들어가는 커피를 알려주세요!"))
			{
				for(Beverage i : Menu)
				{
					if(i.liquid.equals("우유")) //우유가 들어가지 않는 음료 출력
					{
						System.out.println(i.name);
					}
				}
			}
			else if(order.equals("커피가 들어가지 않는 음료를 알려주세요!"))
			{
				for(Beverage i : Menu)
				{
					if(!i.ingred1.equals("에스프레소")) //커피가 들어가지 않는 음료 출력
					{
						System.out.println(i.name);
					}
				}
			}
			else if(order.equals("초콜릿 음료를 알려주세요!"))
			{
				System.out.println("없습니다.");
			}
		}
		
		
		
		
		
		
	}

}
