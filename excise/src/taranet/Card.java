package taranet;

public class Card {

	public static final int DIAMOND =0; //方块
	public final static int CLUB =1; //梅花
	public static final int HEART = 2; //红桃
	public static final int SPADE =3;//黑桃
	public static final int JOKER =4;//王
	
	public final static int THREE =0;
	public final static int FOUR =1;
	public final static int FIEVE=2;
	public final static int SIX =3;
	public final static int SEVEN=4;
	public final static int EIGHT =5;
	public final static int NINE =6;
	public final static int TEN=7;
	public final static int JACK =8;
	public final static int QUEEN = 9;
	public final static int KING =10;
	public final static int ACE =11;
	public final static int DEUCE=12;
	public final static int BLACK=13;
	public final static int COLOR =14;
	
	private int suit; //代表花色
	private int rank; //代表点数
	
	public Card(){}
	public Card(int suit,int rank){
		//this.rank=rank;
		//this.suit=suit;
		setSuit(suit);
		setRank(rank);
	}
	public int getSuit(){
		return suit;
	}
	public void setSuit(int suit){
		if(suit<DIAMOND || suit>JOKER){
		  throw new RuntimeException("花色超出范围");
		}
		this.suit=suit;
	}
	public int getRank(){
		return rank;
	}
	public void setRank(int rank){
		if(rank<THREE||rank >COLOR){
			throw new RuntimeException("点数超出范围");
		}
		this.rank=rank;
	}
	private static final String[] RANK_NAMES =
		{"3","4","5","6","7","8","9","10","J","Q","K","A","2","小王","大王"};
	private static final String[] SUIT_NAMES = {"方块","梅花","红桃","黑桃"};
	//覆盖object 类的toString() 方法，实现对象的文本描述
	public String toString(){
		return SUIT_NAMES[suit]+RANK_NAMES[rank];
	}
	
	public boolean equals(Object obj) {
		if (obj ==null) {
			return false;
		}
		if(this== obj){
			return true;
		}
		if(obj instanceof Card){
			Card other = (Card)obj;
			return this.rank == other.rank && this.suit == other.suit;
		}
		return false;
	}
	public int hashCode(){
		return (suit<<16)+rank;
	}
}
