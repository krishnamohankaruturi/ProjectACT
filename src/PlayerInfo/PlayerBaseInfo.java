package PlayerInfo;

class PlayerBase{
	
	public PlayerBase(String name, float hp, float mp, float dmg, float def) {
		super();
		this.name = name;
		this.baseDmg = dmg;
		this.baseDef = def;
		this.baseHp = hp;
		this.baseMP = mp;
	}

	private String name;
	private float baseDmg;
	private float baseDef;
	private float baseHp;
	private float baseMP;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getBaseDmg() {
		return baseDmg;
	}
	public void setBaseDmg(float baseDmg) {
		this.baseDmg = baseDmg;
	}
	public float getBaseDef() {
		return baseDef;
	}
	public void setBaseDef(float baseDef) {
		this.baseDef = baseDef;
	}
	public float getBaseHp() {
		return baseHp;
	}
	public void setBaseHp(float baseHp) {
		this.baseHp = baseHp;
	}
	public float getBaseMP() {
		return baseMP;
	}
	public void setBaseMP(float baseMP) {
		this.baseMP = baseMP;
	}
	
	public void showPlayerInfo(PlayerBase aPlayer){
		System.out.println();
		System.out.println("-----"+aPlayer.getName()+"-----");
		System.out.println("生命值: "+aPlayer.getBaseHp());
		System.out.println("魔法值: "+aPlayer.getBaseMP());
		System.out.println("攻击力: "+aPlayer.getBaseDmg());
		System.out.println("防御力: "+aPlayer.getBaseDef());
		System.out.println("-------------------------------");

	}
	
	public void attack(PlayerBase Act,PlayerBase Def){
		float costHp = Act.getBaseDmg() - Def.getBaseDef();
		Def.setBaseHp(Def.getBaseHp()-costHp);
		System.out.println("!----    "+Act.getName()+ " 对  "+ Def.getName()+" 造成了  "+ costHp + " 点伤害 -----!");
	}
	
	
}


public class PlayerBaseInfo {

	public static void main(String[] args){
		PlayerBase a1 = new PlayerBase("Naruto",100,0,1000,100);
		PlayerBase b1 = new PlayerBase("Lee",100,0,1100,50);
		
		gameStart(a1, b1);
		
		a1.showPlayerInfo(a1);
		a1.showPlayerInfo(b1);
		a1.attack(a1,b1);
		a1.showPlayerInfo(a1);
		a1.showPlayerInfo(b1);
		
	}
	

	
	public static void gameStart(PlayerBase aPlayer ,PlayerBase anotherPlayer)
	{
		System.out.println("-------------------------------------------------");
		System.out.println(aPlayer.getName()+"                  VS                  "+anotherPlayer.getName());
		System.out.println("-------------------------------------------------");
		
	}
	

}
