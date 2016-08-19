package PlayerInfo;

class PlayerBase{
	
	public PlayerBase(String name, int baseDmg, int baseDef, int baseHp, int baseMP) {
		super();
		this.name = name;
		this.baseDmg = baseDmg;
		this.baseDef = baseDef;
		this.baseHp = baseHp;
		this.baseMP = baseMP;
	}

	private String name;
	private int baseDmg;
	private int baseDef;
	private int baseHp;
	private int baseMP;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBaseDmg() {
		return baseDmg;
	}
	public void setBaseDmg(int baseDmg) {
		this.baseDmg = baseDmg;
	}
	public int getBaseDef() {
		return baseDef;
	}
	public void setBaseDef(int baseDef) {
		this.baseDef = baseDef;
	}
	public int getBaseHp() {
		return baseHp;
	}
	public void setBaseHp(int baseHp) {
		this.baseHp = baseHp;
	}
	public int getBaseMP() {
		return baseMP;
	}
	public void setBaseMP(int baseMP) {
		this.baseMP = baseMP;
	}
	
	
}


public class PlayerBaseInfo {

	public static void main(String[] args){
		PlayerBase a1 = new PlayerBase("Naruto",100,0,1000,100);
		PlayerBase b1 = new PlayerBase("Lee",100,0,1100,50);
		
		gameStart(a1, b1);
		
		showPlayerInfo(a1);
		showPlayerInfo(b1);
		attack(a1,b1);
		showPlayerInfo(a1);
		showPlayerInfo(b1);
		
	}
	
	public static void attack(PlayerBase Act,PlayerBase Def){
		int costHp = Act.getBaseDmg() - Def.getBaseDef();
		Def.setBaseHp(Def.getBaseHp()-costHp);
		System.out.println("!----"+Act.getName()+ "对  "+ Def.getName()+"造成了 "+ costHp + "点伤害");
	}
	
	public static void gameStart(PlayerBase aPlayer ,PlayerBase anotherPlayer)
	{
		System.out.println("-------------------------------------------------");
		System.out.println(aPlayer.getName()+"                  VS                  "+anotherPlayer.getName());
		System.out.println("-------------------------------------------------");
		
	}
	
	public static void showPlayerInfo(PlayerBase aPlayer){
		System.out.println();
		System.out.println("-----"+aPlayer.getName()+"-----");
		System.out.println("生命值: "+aPlayer.getBaseHp());
		System.out.println("魔法值: "+aPlayer.getBaseMP());
		System.out.println("攻击力: "+aPlayer.getBaseDmg());
		System.out.println("防御力: "+aPlayer.getBaseDef());
		System.out.println("-------------------------------");

	}
}
