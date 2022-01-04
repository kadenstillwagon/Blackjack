package Project;
import java.util.*;
public class BlackJack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*
	System.out.println("\n\n\nDealer is dealing...");
				try 
				{
					Thread.sleep(2000);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
	*/
	
	int newgame =1;
	while(newgame==1)
	{
		System.out.println("\n\n\n\t\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("\t\t\t\t\t| |---------   |              /\\       |---------   |  /     ---------      /\\        ---------    |  /  |");
		System.out.println("\t\t\t\t\t| |        |   |             /  \\      |            | /          |         /  \\       |            | /   |");
		System.out.println("\t\t\t\t\t| |________/   |            /____\\     |            |/           |        /    \\      |            |/    |");
		System.out.println("\t\t\t\t\t| |        \\   |           /      \\    |            |\\       |   |       /------\\     |            |\\    |");
		System.out.println("\t\t\t\t\t| |        |   |          /        \\   |            | \\      |   |      /        \\    |            | \\   |");
		System.out.println("\t\t\t\t\t| |---------   |-------  /          \\  |---------   |  \\     ----|     /          \\   |--------    |  \\  |");
		System.out.println("\t\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
	  System.out.println("\n\n\n\n|-------------------------------------------------------------------------------------------------------------------------------|");
		      System.out.println("|Rules:                                                                                                                         |");
		    //System.out.println("|-------------------------------------------------------------------------------------------------------------------------------|");
		      System.out.println("| 1. There is a maximum of SEVEN players allowed.                                                                               |");
		      System.out.println("| 2. Names must be between 2 and 9 letters long and may include numbers or symbols.                                             |");
		      System.out.println("| 3. Bet amounts are in pennies. Starting money and bets must be between 1 and 999999.                                          |");
		      System.out.println("| 4. If asked a question other than name or starting amount, answer only with 1, 2, or 3.                                       |");
		      System.out.println("| 5. If a player gets blackjack, they will win double their bet, unless dealer gets blackjack as well.                          |");
		      System.out.println("| 6. If you select double down, you will double your bet for that round.                                                        |");
		      System.out.println("| 7. Insurance is offered when the dealer has an ace. If you select insurance, you will only lose or gain half of you bet.      |");
		      System.out.println("| 8. If the dealer busts, everyone wins, except those who have already busted.                                                  |");
		      System.out.println("| 9. If the dealer gets blackjack, everyone without blackjack loses. Those with blackjack push.                                 |");
		      System.out.println("| 10. Rouds must be finished.                                                                                                   |");
		      System.out.println("| 11. Money balance is maintained each round, but is reset if a new game is started.                                            |");
		      System.out.println("| 12. Players can be added or removed after each round. An eighth player cannot be added and a single player cannot be removed. |");
		      System.out.println("|-------------------------------------------------------------------------------------------------------------------------------|\n\n\n\n");
		    
		    int start=0;
			while(start!=1)
			{
		    Scanner sg = new Scanner(System.in);
			System.out.println("Enter 1 to Start Game:\t");
			start = sg.nextInt();
			
			if(start==1)
			{
			System.out.println("\n\n\n");
		    play();
			}
			else
			{
				System.out.println("\nEnter 1 Only!\n");
			}
			}
		int wrong=0;
		while(wrong==0)
		{
		Scanner ng = new Scanner(System.in);
		System.out.println("Would you like to start a new game?");
		System.out.println("1. Yes\n2. No");
		newgame= ng.nextInt();
		//String newgameS=ng.nextLine();
		
		if(newgame==1)
		{
			wrong=1;
		}
		if(newgame==2)
		{
			wrong=1;
			System.out.println("Goodbye");
		}
		else if(newgame!=1 && newgame!=2)
		{
			wrong=0;
			System.out.println("\nEnter only 1 or 2!\n");
		}
		
		}
	}
		

	}
	static void play()
	{
		int d2value=0;
		int players=8;
		
		while(players>7)
		{
		Scanner pl = new Scanner(System.in);
		System.out.print("Enter number of players: \t");
		players= pl.nextInt();
		
		if(players>7)
		{
			System.out.println("\n7 is the Maxium number of players!\n");
		}
		}
		
		Scanner de = new Scanner(System.in);
		System.out.print("Enter number of decks:\t");
		int decks= de.nextInt();
		
		playingDeck p = new playingDeck(decks);
		p.shuffle();
		
		GamePlayers gp=new GamePlayers(players);
		Dealer d = new Dealer();
		
	int cont=1;
	while(cont==1 || cont==3)
	{
		
		setup(players, gp, d);
		
		for(int i=1; i<=players; i++)
		{
			setBett(i, gp);
		}
	
	//System.out.println("\n\n\n\nDealer is dealing...\n\n\n\n");
	
	
	System.out.println("\n\n\nDealer is dealing...");
	try 
	{
		Thread.sleep(1000);
	} 
	catch (InterruptedException e) 
	{
		e.printStackTrace();
	}
	
	
	startRound(p, gp, players, d, d2value);
	
	
	
	
	int wrongagain=0;
	while(wrongagain==0)
	{
	Scanner ag = new Scanner(System.in);
	System.out.println("Play Another Round?");
	System.out.println("1. Yes\n2. No\n3. Add or Remove a Player");
	cont= ag.nextInt();
	
	reset(players, gp, d);
	
	if(cont==1)
	{
	wrongagain=1;
	reset(players, gp, d);
	}
	else if(cont==3)
	{
		wrongagain=1;
		int addremove=1;
		while(addremove!=3)
		{
		Scanner ar = new Scanner(System.in);
		System.out.println("\n\n\nAdd or Remove a Player?");
		System.out.println("1. Add\n2. Remove\n3. No");
		addremove= ar.nextInt();
		
		if(addremove==1)
		{
			if(players<7)
			{
			players=addPlayer(gp, players);
			}
			else
			{
				System.out.println("Too Many Players(The Max is SEVEN)");
			}
		}
		else if(addremove==2)
		{
			if(players>1)
			{
			Scanner re = new Scanner(System.in);
			System.out.println("Which player do you want to remove?");
			for(int i=1;i<=players; i++)
			{
			System.out.println(i+". "+gp.getName(i));
			}
			int removed= re.nextInt();
			
			players=removePlayer(gp, removed, players);
			}
			else
			{
				System.out.println("\nCannot Remove One Player\n");
			}
		}
		else if(addremove==3)
		{
			
		}
		else
		{
			System.out.println("\nEnter only 1, 2, or 3\n");
		}
	}
}
	
	
	else if(cont==2)
	{
		wrongagain=1;
		System.out.println("\n\nFINAL AMOUNTS\n~~~~~~~~~~~~~\n\n");
		for(int i=1; i<=players; i++)
		{
			System.out.println(i+". "+gp.getName(i)+":\t"+gp.getMoney(i)+"\n   "+"Money Won:\t"+((gp.getMoney(i))-(gp.getStartingMoney(i)))+"\n");
		}
		System.out.println(d.getName()+":\t"+d.getMoney()+"\nMoney Won:\t"+((d.getMoney())-(d.getStartingMoney()))+"\n\n");
		System.out.println("\n\n\n");
		fullreset(players, gp, d, decks);
	}
	else
	{
		wrongagain=0;
		System.out.println("\nEnter only 1, 2, or 3!\n");
	}
	
	}
  }
}
	
		

	
	static void startRound(playingDeck deck, GamePlayers gp, int players, Dealer d, int d2value)
	{
		
		for(int i=1; i<=players; i++)
		{
			int first =deck.deal().getValue();
			int second=deck.deal().getValue();
			gp.setHand(i, first+second);
			if(gp.getHand(i)==21)
			{
				blackjack(i, gp.getBet(i), gp, d);
				gp.changebj(i);
				gp.setStatus(i, 1);
			}
			if(first==11 || second==11)
			{
				gp.changeContainsAce(i);
			}
			
		}
		int dfirstvalue=deck.deal().getValue();
		d.setHand(dfirstvalue);
		d2value=deck.deal().getValue();
		setup(players, gp, d);//remember to give dealer second card
		nextStep(players, gp, deck, d, d2value, dfirstvalue);
		
		
		
		
	}
	static void nextStep(int players, GamePlayers gp, playingDeck deck, Dealer d, int d2value, int dfirstvalue)
	{
	for(int i=1; i<=players; i++)
	{
		if(gp.getbj(i)==false)
		{
			
		if(dfirstvalue==11)
		{
			insurance(i, gp);
			setup(players, gp, d);
		}
		else
		{
		
		}
		int bet =gp.getBet(i);
		if(hit_stand(i, gp)==1)
		{
			doubleDown(i, gp, players, d);
			gp.setHand(i, deck.deal().getValue());
			setup(players, gp, d);
			if(gp.getHand(i)>21)
			{
				if(gp.getContainsAce(i)==true)
				{
					gp.setHand(i, -10);
					setup(players, gp, d);
					if(gp.getHand(i)<21)
					{
						if(hit_stand(i, gp)==1)
						{
							gp.setHand(i, deck.deal().getValue());
							setup(players, gp, d);
							if(gp.getHand(i)>21)
							{
								gp.setStatus(i, 4);
								win_lose(1, i, bet, gp, d);
								setup(players, gp, d);
							}
							else if(gp.getHand(i)<21)
							{
								if(hit_stand(i, gp)==1)
								{
			
									gp.setHand(i, deck.deal().getValue());
									setup(players, gp, d);
									if(gp.getHand(i)>21)
									{
										gp.setStatus(i, 4);
										win_lose(1, i, bet, gp, d);
										setup(players, gp, d);
									}
								}
								else
								{
									setup(players, gp, d);
								}
							}
							else
							{
								setup(players, gp, d);
							}
						}
						else
						{
							setup(players, gp, d);
						}
					}
					else
					{
						setup(players, gp, d);
					}
				}
				else
				{
				gp.setStatus(i, 4);
				win_lose(1, i, bet, gp, d);
				setup(players, gp, d);
				}
			
			
			}
			else if(gp.getHand(i)<21)
			{
				if(hit_stand(i, gp)==1)
				{
					gp.setHand(i, deck.deal().getValue());
					setup(players, gp, d);
					if(gp.getHand(i)>21)
					{
						if(gp.getContainsAce(i)==true)
						{
							gp.setHand(i, -10);
							setup(players, gp, d);
							if(gp.getHand(i)<21)
							{
								if(hit_stand(i, gp)==1)
								{
									gp.setHand(i, deck.deal().getValue());
									setup(players, gp, d);
									if(gp.getHand(i)>21)
									{
										gp.setStatus(i, 4);
										win_lose(1, i, bet, gp, d);
										setup(players, gp, d);
									}
									else if(gp.getHand(i)<21)
									{
										if(hit_stand(i, gp)==1)
										{
											gp.setHand(i, deck.deal().getValue());
											setup(players, gp, d);
											if(gp.getHand(i)>21)
											{
												gp.setStatus(i, 4);
												win_lose(1, i, bet, gp, d);
												setup(players, gp, d);
											}
										}
										else
										{
											setup(players, gp, d);
										}
									}
									else
									{
										setup(players, gp, d);
									}
								}
								else
								{
									setup(players, gp, d);
								}
							}
							else
							{
								setup(players, gp, d);
							}
						}
						else
						{
						gp.setStatus(i, 4);
						win_lose(1, i, bet, gp, d);
						setup(players, gp, d);
						}
					
					}
					else if(gp.getHand(i)<21)
					{
						if(hit_stand(i, gp)==1)
						{
							gp.setHand(i, deck.deal().getValue());
							setup(players, gp, d);
							if(gp.getHand(i)>21)
							{
								if(gp.getContainsAce(i)==true)
								{
									gp.setHand(i, -10);
									setup(players, gp, d);
									if(gp.getHand(i)<21)
									{
										if(hit_stand(i, gp)==1)
										{
											gp.setHand(i, deck.deal().getValue());
											setup(players, gp, d);
											if(gp.getHand(i)>21)
											{
												gp.setStatus(i, 4);
												win_lose(1, i, bet, gp, d);
												setup(players, gp, d);
											}
											else if(gp.getHand(i)<21)
											{
												if(hit_stand(i, gp)==1)
												{
													gp.setHand(i, deck.deal().getValue());
													setup(players, gp, d);
													if(gp.getHand(i)>21)
													{
														gp.setStatus(i, 4);
														win_lose(1, i, bet, gp, d);
														setup(players, gp, d);
													}
												}
												else
												{
													setup(players, gp, d);
												}
											}
											else
											{
												setup(players, gp, d);
											}
										}
										else
										{
											setup(players, gp, d);
										}
									}
									else
									{
										setup(players, gp, d);
									}
								}
								else
								{
								gp.setStatus(i, 4);
								win_lose(1, i, bet, gp, d);
								setup(players, gp, d);
								}
							
							}
							else if(gp.getHand(i)<21)
							{
								if(hit_stand(i, gp)==1)
								{
									gp.setHand(i, deck.deal().getValue());
									setup(players, gp, d);
									if(gp.getHand(i)>21)
									{
										if(gp.getContainsAce(i)==true)
										{
											gp.setHand(i, -10);
											setup(players, gp, d);
											if(gp.getHand(i)<21)
											{
												if(hit_stand(i, gp)==1)
												{
													gp.setHand(i, deck.deal().getValue());
													setup(players, gp, d);
													if(gp.getHand(i)>21)
													{
														gp.setStatus(i, 4);
														win_lose(1, i, bet, gp, d);
														setup(players, gp, d);
													}
													else if(gp.getHand(i)<21)
													{
														if(hit_stand(i, gp)==1)
														{
															gp.setHand(i, deck.deal().getValue());
															setup(players, gp, d);
															if(gp.getHand(i)>21)
															{
																gp.setStatus(i, 4);
																win_lose(1, i, bet, gp, d);
																setup(players, gp, d);
															}
														}
														else
														{
															setup(players, gp, d);
														}
													}
													else
													{
														setup(players, gp, d);
													}
												}
												else
												{
													setup(players, gp, d);
												}
											}
											else
											{
												setup(players, gp, d);
											}
										}
										else
										{
										gp.setStatus(i, 4);
										win_lose(1, i, bet, gp, d);
										setup(players, gp, d);
										}
									
									}
									else if(gp.getHand(i)<21)
									{
										if(hit_stand(i, gp)==1)
										{
											gp.setHand(i, deck.deal().getValue());
											setup(players, gp, d);
											if(gp.getHand(i)>21)
											{
												gp.setStatus(i, 4);
												win_lose(1, i, bet, gp, d);
												setup(players, gp, d);
											
											}
											
										
										}
										else
										{
											setup(players, gp, d);
										}	
									}
									else
									{
										setup(players, gp, d);
									}
								}
								else
								{
									setup(players, gp, d);
								}	
							}
							else
							{
								setup(players, gp, d);
							}
						}
						else
						{
							setup(players, gp, d);
						}	
					}
					else
					{
						setup(players, gp, d);
					}
				}
				else
				{
					setup(players, gp, d);
				}	
			}
			else
			{
				setup(players, gp, d);
			}
		}
		else
		{
			setup(players, gp, d);
		}
		}
	}
	
	System.out.println("\n\n\nDealer is dealing...");
	try 
	{
		Thread.sleep(2000);
	} 
	catch (InterruptedException e) 
	{
		e.printStackTrace();
	}
	
	
	d.setHand(d2value);
	if(d.getHand()==21)
	{
		dealerBlackjack(players, gp, d);
		setup(players, gp, d);
	}
	else
	{
	while(d.getHand()<17)
	{
	d.setHand(deck.deal().getValue());
	}
	
	endRound(d, gp, deck, players);
	}
	}
	
	static void endRound(Dealer d, GamePlayers gp, playingDeck deck, int players)
	{
		for(int player=1; player<=players; player++)
		{
		
		if(d.getHand()>21)
		{
			System.out.println("\n\n\nDEALER BUST");
			DealerBust(gp, d, players, player);
			setup(players, gp, d);
		
		}
		else if(d.getHand()<=21)
		{
			if(gp.getStatus(player).contains("Loss"))
			{
				
			}
			else
			{
			
			if(d.getHand()<gp.getHand(player))
			{
				win_lose(2, player, gp.getBet(player), gp, d);
				gp.setStatus(player, 1);
			}
			else if(d.getHand()>gp.getHand(player))
			{
				win_lose(1, player, gp.getBet(player), gp, d);
				gp.setStatus(player, 2);
			}
			else
			{
				if(gp.getbj(player)==false)
				{
				gp.setStatus(player, 3);
				}
			}
			}
			setup(players, gp, d);
		}
		}
					
				
	
	}
	static void setup(int numplayers, GamePlayers players, Dealer d)
	{

		if(numplayers==1)
		{
		System.out.println("\n\n\n\n\n\n"+playerInfo(players, 1, players.getHand(1), 0, d)+"\n");
		}
		else if(numplayers==2)
		{
		System.out.println("\n\n\n\n\n\n"+playerInfo(players, 1, players.getHand(1), 1, d)+"\n\n"+playerInfo(players, 2, players.getHand(2), 0, d)+"\n");
		}
		else if(numplayers==3)
		{
		System.out.println("\n\n\n\n\n\n"+playerInfo(players, 1, players.getHand(1), 1, d)+"\n\n"+playerInfo(players, 2, players.getHand(2), 0, d)+"\n\n"+playerInfo(players, 3, players.getHand(3), 1, d)+"\n");
		}
		else if(numplayers==4)
		{
		System.out.println("\n\n\n\n\n\n"+playerInfo(players, 1, players.getHand(1), 2, d)+"\n\n"+playerInfo(players, 2, players.getHand(2), 1, d)+"\n\n"+playerInfo(players, 3, players.getHand(3), 0, d)+"\n\n"+playerInfo(players, 4, players.getHand(4), 1, d)+"\n");
		}
		else if(numplayers==5)
		{
		System.out.println("\n\n\n\n\n\n"+playerInfo(players, 1, players.getHand(1), 2, d)+"\n\n"+playerInfo(players, 2, players.getHand(2), 1, d)+"\n\n"+playerInfo(players, 3, players.getHand(3), 0, d)+"\n\n"+playerInfo(players, 4, players.getHand(4), 1, d)+"\n\n"+playerInfo(players, 5, players.getHand(5), 2, d)+"\n");
		}
		else if(numplayers==6)
		{
		System.out.println("\n\n\n\n\n\n"+playerInfo(players, 1, players.getHand(1), 3, d)+"\n\n"+playerInfo(players, 2, players.getHand(2), 2, d)+"\n\n"+playerInfo(players, 3, players.getHand(3), 1, d)+"\n\n"+playerInfo(players, 4, players.getHand(4), 0, d)+"\n\n"+playerInfo(players, 5, players.getHand(5), 1, d)+"\n\n"+playerInfo(players, 6, players.getHand(6), 2, d)+"\n");
		}
		else if(numplayers==7)
		{
		System.out.println("\n\n\n\n\n\n"+playerInfo(players, 1, players.getHand(1), 3, d)+"\n\n"+playerInfo(players, 2, players.getHand(2), 2, d)+"\n\n"+playerInfo(players, 3, players.getHand(3), 1, d)+"\n\n"+playerInfo(players, 4, players.getHand(4), 0, d)+"\n\n"+playerInfo(players, 5, players.getHand(5), 1, d)+"\n\n"+playerInfo(players, 6, players.getHand(6), 2, d)+"\n\n"+playerInfo(players, 7, players.getHand(7), 3, d)+"\n");
		}
		
	}
	static String playerInfo(GamePlayers players, int num, int hand, int distance, Dealer dealer)
	{
		String str="";
		if(distance==0)
		{
			if(players.getBet(num)<=99 && players.getHand(num)<=9 && players.getStatus(num).length()<5)
			{
				str+= "----------------\nName: "+players.getName(num)+"\t\t\t----------------"+"\nBalance: "+players.getMoney(num)+"\t\t\tName: "+dealer.getName()+"\nBet: "+players.getBet(num)+"\t\t\t\tBalance: "+dealer.getMoney()+"\nHand: "+players.getHand(num)+"\t\t\t\tHand: "+dealer.getHand()+"\nStatus: "+players.getStatus(num)+"\t\t\t----------------\n----------------";
			}
			else if(players.getBet(num)<=99 && players.getHand(num)>9 && players.getStatus(num).length()<5)
			{
				str+= "----------------\nName: "+players.getName(num)+"\t\t\t----------------"+"\nBalance: "+players.getMoney(num)+"\t\t\tName: "+dealer.getName()+"\nBet: "+players.getBet(num)+"\t\t\t\tBalance: "+dealer.getMoney()+"\nHand: "+players.getHand(num)+"\t\t\tHand: "+dealer.getHand()+"\nStatus: "+players.getStatus(num)+"\t\t\t----------------\n----------------";
			}
			else if(players.getBet(num)>99 && players.getHand(num)>9 && players.getStatus(num).length()<5)
			{
				str+= "----------------\nName: "+players.getName(num)+"\t\t\t----------------"+"\nBalance: "+players.getMoney(num)+"\t\t\tName: "+dealer.getName()+"\nBet: "+players.getBet(num)+"\t\t\tBalance: "+dealer.getMoney()+"\nHand: "+players.getHand(num)+"\t\t\tHand: "+dealer.getHand()+"\nStatus: "+players.getStatus(num)+"\t\t\t----------------\n----------------";
			}
			else if(players.getBet(num)>99 && players.getHand(num)<=9 && players.getStatus(num).length()<5)
			{
				str+= "----------------\nName: "+players.getName(num)+"\t\t\t----------------"+"\nBalance: "+players.getMoney(num)+"\t\t\tName: "+dealer.getName()+"\nBet: "+players.getBet(num)+"\t\t\tBalance: "+dealer.getMoney()+"\nHand: "+players.getHand(num)+"\t\t\t\tHand: "+dealer.getHand()+"\nStatus: "+players.getStatus(num)+"\t\t\t----------------\n----------------";
			}
			if(players.getBet(num)<=99 && players.getHand(num)<=9 && players.getStatus(num).length()>5)
			{
				str+= "----------------\nName: "+players.getName(num)+"\t\t\t----------------"+"\nBalance: "+players.getMoney(num)+"\t\t\tName: "+dealer.getName()+"\nBet: "+players.getBet(num)+"\t\t\t\tBalance: "+dealer.getMoney()+"\nHand: "+players.getHand(num)+"\t\t\t\tHand: "+dealer.getHand()+"\nStatus: "+players.getStatus(num)+"\t\t----------------\n----------------";
			}
			else if(players.getBet(num)<=99 && players.getHand(num)>9 && players.getStatus(num).length()>5)
			{
				str+= "----------------\nName: "+players.getName(num)+"\t\t\t----------------"+"\nBalance: "+players.getMoney(num)+"\t\t\tName: "+dealer.getName()+"\nBet: "+players.getBet(num)+"\t\t\t\tBalance: "+dealer.getMoney()+"\nHand: "+players.getHand(num)+"\t\t\tHand: "+dealer.getHand()+"\nStatus: "+players.getStatus(num)+"\t\t----------------\n----------------";
			}
			else if(players.getBet(num)>99 && players.getHand(num)>9 && players.getStatus(num).length()>5)
			{
				str+= "----------------\nName: "+players.getName(num)+"\t\t\t----------------"+"\nBalance: "+players.getMoney(num)+"\t\t\tName: "+dealer.getName()+"\nBet: "+players.getBet(num)+"\t\t\tBalance: "+dealer.getMoney()+"\nHand: "+players.getHand(num)+"\t\t\tHand: "+dealer.getHand()+"\nStatus: "+players.getStatus(num)+"\t\t----------------\n----------------";
			}
			else if(players.getBet(num)>99 && players.getHand(num)<=9 && players.getStatus(num).length()>5)
			{
				str+= "----------------\nName: "+players.getName(num)+"\t\t\t----------------"+"\nBalance: "+players.getMoney(num)+"\t\t\tName: "+dealer.getName()+"\nBet: "+players.getBet(num)+"\t\t\tBalance: "+dealer.getMoney()+"\nHand: "+players.getHand(num)+"\t\t\t\tHand: "+dealer.getHand()+"\nStatus: "+players.getStatus(num)+"\t\t----------------\n----------------";
			}
		}
		if(distance==1)
		{
		str+= "\t\t\t----------------\n\t\t\tName: "+players.getName(num)+"\n\t\t\tBalance: "+players.getMoney(num)+"\n\t\t\tBet: "+players.getBet(num)+"\n\t\t\tHand: "+players.getHand(num)+"\n\t\t\tStatus: "+players.getStatus(num)+"\n\t\t\t----------------";
		}
		if(distance==2)
		{
		str+= "\t\t\t\t\t\t----------------\n\t\t\t\t\t\tName: "+players.getName(num)+"\n\t\t\t\t\t\tBalance: "+players.getMoney(num)+"\n\t\t\t\t\t\tBet: "+players.getBet(num)+"\n\t\t\t\t\t\tHand: "+players.getHand(num)+"\n\t\t\t\t\t\tStatus: "+players.getStatus(num)+"\n\t\t\t\t\t\t----------------";
		}
		if(distance==3)
		{
		str+= "\t\t\t\t\t\t\t\t\t----------------\n\t\t\t\t\t\t\t\t\tName: "+players.getName(num)+"\n\t\t\t\t\t\t\t\t\tBalance: "+players.getMoney(num)+"\n\t\t\t\t\t\t\t\t\tBet: "+players.getBet(num)+"\n\t\t\t\t\t\t\t\t\tHand: "+players.getHand(num)+"\n\t\t\t\t\t\t\t\t\tStatus: "+players.getStatus(num)+"\n\t\t\t\t\t\t\t\t\t----------------";
		}
		return str;
		
	}
	
	static void win_lose(int winlose, int player, int Bet, GamePlayers gp, Dealer d)
	{
		if(winlose==2)
		{
			gp.addMoney(player, Bet*2);
			d.loseMoney(Bet);
		}
		if(winlose==1)
		{
			gp.loseMoney(player, 0);
			d.addMoney(Bet);
		}
	}
	static void blackjack(int player, int Bet, GamePlayers gp, Dealer d)
	{
			gp.addMoney(player, Bet*3);
			d.loseMoney(Bet*2);

	}
	
	static void setBett(int player, GamePlayers gp)
	{
		int mon=1000000;
		while(mon>999999)
		{
		Scanner sb= new Scanner(System.in);
		System.out.print(gp.getName(player)+" Enter Bet: \t");
		mon = sb.nextInt();
		
		if(mon>999999)
		{
			System.out.println("Bet must be under 1000000");
		}
		
		}
		
		gp.setBet(player, mon);
		gp.loseMoney(player, mon);
	}
	static int hit_stand(int player, GamePlayers gp)
	{
		int hos=0;
		while(hos!=1 && hos!=2)
		{
		Scanner hs= new Scanner(System.in);
		System.out.println(gp.getName(player)+":");
		System.out.println("1. Hit\n2. Stand");
		hos = hs.nextInt();
		
		if(hos!=1 && hos!=2)
		{
			System.out.println("\nEnter only 1 or 2!\n");
		}
		}
		return hos;
	}
	static void DealerBust(GamePlayers gp, Dealer d, int players, int player)
	{
		if(gp.getbj(player)==false && gp.getHand(player)<=21)
		{
		win_lose(2, player, gp.getBet(player), gp, d);
		gp.setStatus(player, 1);
		
		}
		
	}
	static void reset(int players, GamePlayers gp, Dealer d)
	{
		for(int i=1; i<=players; i++)
		{
			gp.setBet(i, 0);
			gp.setHand(i, -gp.getHand(i));
			gp.setStatus(i, 0);
			gp.resetContainsAce(i);
			gp.resetbj(i);
		}
		d.setHand(-d.getHand());
	}
	static void fullreset(int players, GamePlayers gp, Dealer d, int decks)
	{
		for(int i=1; i<=players; i++)
		{
			gp.setBet(i, 0);
			gp.setHand(i, -gp.getHand(i));
			gp.setStatus(i, 0);
			gp.resetContainsAce(i);
			gp.resetbj(i);
			gp.loseMoney(i, gp.getMoney(i));
			gp.setName(i, "");
		}
		d.setHand(0);
		players=0;
		decks=0;
	}
	static void dealerBlackjack(int players, GamePlayers gp, Dealer d)
	{
		System.out.println("DEALER BLACKJACK");
		for(int i=1; i<=players; i++)
		{
			if(gp.getbj(i)==false)
			{
				win_lose(1, i, gp.getBet(i), gp, d);
				gp.setStatus(i, 2);
			}
			else
			{
				win_lose(1, i, gp.getBet(i), gp, d);
				gp.setStatus(i, 3);
			}
		}
	}
	static void doubleDown(int player, GamePlayers gp, int players, Dealer d)
	{
		int dd=0;
		while(dd!=1 && dd!=2)
		{
		Scanner ys= new Scanner(System.in);
		System.out.println(gp.getName(player)+": Double Down?");
		System.out.println("1. Yes\n2. No");
		dd = ys.nextInt();
		
		if(dd==1)
		{
			gp.loseMoney(player, gp.getBet(player));
			gp.setBet(player, gp.getBet(player)*2);
			setup(players, gp, d);
		}
		else if(dd!=1 && dd!=2)
		{
			System.out.println("\nEnter only 1 or 2!\n");
		}
		}
	}
	static void insurance(int player, GamePlayers gp)
	{
		int insure=0;
		while(insure!=1 && insure!=2)
		{
		Scanner in= new Scanner(System.in);
		System.out.println("Dealer Has an Ace:\n"+gp.getName(player)+": Would you like to Purchase Insurance?");
		System.out.println("1. Yes\n2. No");
		insure = in.nextInt();
		
		if(insure==1)
		{
			gp.setBet(player, (gp.getBet(player)/2));
		}
		else if(insure!=1 && insure!=2)
		{
			System.out.println("\nEnter only 1 or 2!\n");
		}
		}
	}
	
	static int addPlayer(GamePlayers gp, int players)
	{
		players++;
		gp.addPlayer();
		return players;
	}
	static int removePlayer(GamePlayers gp, int i, int players)
	{
		gp.removePlayer(i);
		players--;
		return players;
	}
}

class Card
{
	private int cardnumber;
	private int suit;
	
	public Card(int cn, int s)
	{
		cardnumber=cn;
		suit=s;
	}
	public String getSuit()
	{
		String realSuit="";
		if(suit==1)
		{
			realSuit+="Diamonds";
		}
		else if(suit==2)
		{
			realSuit+="Hearts";
		}
		else if(suit==3)
		{
			realSuit+="Spades";
		}
		else if(suit==4)
		{
			realSuit+="Clubs";
		}
		return realSuit;
	}
	public int getValue()
	{
		int value=0;
		for(int i=2; i<11; i++)
		{
			if(i==cardnumber)
			{
				value=i;
			}
		}
		for(int i=11; i<14; i++)
		{
			if(i==cardnumber)
			{
			value=10;
			}
		}
		if(cardnumber==14)
		{
			value=11;
		}
		return value;
		
	}
	public String getName()
	{
		String name="";
		for(int i=2; i<11; i++)
		{
			if(cardnumber==i)
			{
			name+=i;
			}
		}
		if(cardnumber==11)
		{
			name+="Jack";
		}
		else if(cardnumber==12)
		{
			name+="Queen";
		}
		else if(cardnumber==13)
		{
			name+="King";
		}
		else if(cardnumber==14)
		{
			name+="Ace";
		}
		return name;
		
	}
	
	public String toString()
	{
		String str="";
		str+="The "+getName()+" of "+getSuit();
		return str;
	}
	
}

class playingDeck
{
	Card[] playDeck;
	int decks=0;
	int count=0;
	
	public playingDeck(int d)
	{
		decks=d;
		playDeck = new Card[decks*52];
	for(int k =1; k<=decks; k++)
	{	
		for(int i=1; i<=4;i++)
		{
			for(int j =2; j<=14; j++)
			{
				playDeck[count]=new Card(j, i);
				count++;
			}

				
		}
	}
	}
	public void shuffle()
	{
	Random rand = new Random();
	for(int i=0; i<10000; i++)
	{	
		int r1 =0;
		int r2=0;
		while(r1==r2)
		{
		r1 = rand.nextInt(decks*52);
		r2 = rand.nextInt(decks*52);
		}
		
		Card temp=playDeck[r1];
		playDeck[r1]=playDeck[r2];
		playDeck[r2]=temp;
	}
	}
	public Card deal()
	{
		
		Card dCard=null;
		
			if(count>1)
			{
			dCard=playDeck[count-1];
			playDeck[count-1]=null;
			count--;
			}
		
			else if(count==1)
			{
				playingDeck npd= new playingDeck(decks);
				npd.shuffle();
				count=decks*52;
				
				dCard=playDeck[count-1];
				playDeck[count-1]=null;
				count--;
			}	
		
		
		return dCard;
		
	}
	
	public String toString()
	{
		String str="";
		for(int i=0; i<playDeck.length; i++)
		{
		str+=playDeck[i]+", ";
		}
		return str;
	}
}
class Player
{
	private String name;
	private int money;
	private int startingMoney;
	private int hand=0;
	private int bet=0;
	private boolean bj=false;
	private String status="";
	private boolean containsAce=false;
	
	public Player()
	{
		int toolong=10;
		while(toolong>9 || toolong<=1)
		{
		Scanner nm = new Scanner(System.in);
		System.out.print("\nEnter Player Name:\t");
		name=nm.nextLine();
		
		toolong=name.length();
		if(toolong>9 || toolong<=1)
		{
			System.out.println("\nName must between 2 and 9 characters.\n");
		}
		}
		
		int toomuch=1000000;
		while(toomuch>999999)
		{
		Scanner mn= new Scanner(System.in);
		System.out.print("Enter Starting Amount:\t");
		money = mn.nextInt();
		startingMoney=money;
		
		toomuch=money;
		if(toomuch>999999)
		{
			System.out.println("\nStarting Amount must be under 999999\n");
		}
		}
		
	}
	public String getName()
	{
		return name;
	}
	public void setName(String i)
	{
		name=i;
	}
	public int getMoney()
	{
		return money;
	}
	public void addMoney(int i)
	{
		money=money+i;
	}
	public void loseMoney(int i)
	{
		money=money-i;
	}
	public int getStartingMoney()
	{
		return startingMoney;
	}
	public int getHand()
	{
		return hand;
	}
	public void setHand(int i)
	{
		hand=hand+i;
	}
	public int getBet()
	{
		return bet;
	}
	public void setBet(int i)
	{
		bet=i;
	}
	public boolean getbj()
	{
		return bj;
	}
	public void changebj()
	{
		bj=true;
	}
	public void resetbj()
	{
		bj=false;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(int i)
	{
		if(i==0)
		{
			status="";
		}
		else if(i==1)
		{
			status="Win";
		}
		else if(i==2)
		{
			status="Loss";
		}
		else if(i==3)
		{
			status="Push";
		}
		else
		{
			status="Bust(Loss)";
		}
	}
	public void changeStatus()
	{
		status="Win";
		money+=bet;
	}
	public void changeContainsAce()
	{
		containsAce=true;
	}
	public boolean getContainsAce()
	{
		return containsAce;
	}
	public void resetContainsAce()
	{
		containsAce=false;
	}
	
}
class GamePlayers
{
	Player[] players;
	int numOfPlayers;
	
	public GamePlayers(int np)
	{
		numOfPlayers=np;
		players= new Player[7];
		for(int i=0; i<numOfPlayers; i++)
		{
			players[i]=new Player();
		}
		
	}
	public void addPlayer()
	{
		numOfPlayers=numOfPlayers+1;
		players[numOfPlayers-1]=new Player();
	}
	public void removePlayer(int i)
	{
		Player temp=players[i-1];
		players[i-1]=players[numOfPlayers-1];
		players[numOfPlayers-1]=temp;
		
	}
	public String getName(int i)
	{
		return players[i-1].getName();
	}
	public void setName(int i, String j)
	{
		players[i-1].setName(j);
	}
	public int getMoney(int i)
	{
		return players[i-1].getMoney();
	}
	public void addMoney(int i, int j)
	{
		players[i-1].addMoney(j);
	}
	public void loseMoney(int i, int j)
	{
		players[i-1].loseMoney(j);
	}
	public int getStartingMoney(int i)
	{
		return players[i-1].getStartingMoney();
	}
	public int getHand(int i)
	{
		return players[i-1].getHand();
	}
	public void setHand(int i, int j)
	{
		players[i-1].setHand(j);
	}
	public int getBet(int i)
	{
		return players[i-1].getBet();
	}
	public void setBet(int i, int j)
	{
		players[i-1].setBet(j);
	}
	public boolean getbj(int i)
	{
		return players[i-1].getbj();
	}
	public void changebj(int i)
	{
		players[i-1].changebj();
	}
	public void resetbj(int i)
	{
		players[i-1].resetbj();
	}
	public String getStatus(int i)
	{
		return players[i-1].getStatus();
	}
	public void setStatus(int i, int j)
	{
		players[i-1].setStatus(j);
	}
	public void changeStatus(int i)
	{
		players[i-1].changeStatus();
	}
	public boolean getContainsAce(int i)
	{
		return players[i-1].getContainsAce();
	}
	public void changeContainsAce(int i)
	{
		players[i-1].changeContainsAce();
	}
	public void resetContainsAce(int i)
	{
		players[i-1].resetContainsAce();
	}
}
class Dealer
{
	private String name="Dealer";
	private int money=1000000;
	private int startingMoney=1000000;
	private int hand =0;
	
	public String getName()
	{
		return name;
	}
	public int getMoney()
	{
		return money;
	}
	public void addMoney(int i)
	{
		money=money+i;
	}
	public void loseMoney(int i)
	{
		money=money-i;
	}
	public int getStartingMoney()
	{
		return startingMoney;
	}
	public int getHand()
	{
		return hand;
	}
	public void setHand(int i)
	{
		hand=hand+i;
	}
}