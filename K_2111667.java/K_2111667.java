import java.util.Scanner;

public class K_2111667 {

	static class Computer {
		private String Brand;
		private String Model;
		private String SN;
		private double Price;

		private Computer(String brand, String model, String sn, double price) {
			Brand = brand;
			Model = model;
			SN = sn;
			Price = price;
		}

		public String getBrand() {
			return Brand;
		}

		public String getModel() {
			return Model;
		}

		public String getSN() {
			return SN;
		}

		public double getPrice() {
			return Price;
		}

		public void setBrand(String name) {
			this.Brand = name;
		}

		public void setModel(String name) {
			this.Model = name;
		}

		public void setSN(String name) {
			this.SN = name;
		}

		public void setPrice(double name) {
			this.Price = name;
		}

	}

	public static void displaycomputerinfo(int i, int maxComputers, int count, Computer[] inventory) {
		System.out.println("display compute info for that index \n ");
		System.out.println("Brand " + inventory[i].getBrand());
		System.out.println("model " + inventory[i].getModel());
		System.out.println("serialnumber " + inventory[i].getSN());
		System.out.println("price " + inventory[i].getPrice());
		System.out.println(" ************************");

	}

	public static void findcomputersby(String check, int maxComputers, int count, Computer[] inventory) {

		int flag = 0;
		for (int i = 0; i < count; i++) {
			if (check.equals(inventory[i].getBrand())) {
				displaycomputerinfo(i, maxComputers, count, inventory);
				flag = 1;
			}

		}
		if (flag == 0)
			System.out.print("no computer for that particular brand found.Switching to main menu \n ");
		mainmenu(maxComputers, count, inventory);

	}

	public static void findCheaperThan(int maxprice, int maxComputers, int count, Computer[] inventory) {
		int flag = 0;
		for (int i = 0; i < count; i++) {
			if ((inventory[i].getPrice() < maxprice)) {
				displaycomputerinfo(i, maxComputers, count, inventory);
				flag = 1;
			}

		}
		if (flag == 0)
			System.out.print("no computer for that particular price found\n  ");
		mainmenu(maxComputers, count, inventory);

	}

	public static void entercomputerinfo(int maxComputers, int count, Computer[] inventory) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("\t 1) Enter Brand");
		inventory[count].setBrand(scanner.next());

		System.out.println("\t 2)Model");
		inventory[count].setModel(scanner.next());
		while (true) {
			int flag1 = 0;
			System.out.println("\t 3)SN");
			inventory[count].setSN(scanner.next());
			for (int i = 0; i < count; i++) {
				if ((inventory[count].getBrand().equals(inventory[i].getBrand()))
						&& (inventory[count].getSN().equals(inventory[i].getSN()))) {
					System.out.println("serial number for that particular brand already exist.enter another one ");
					flag1 = 1;

				}

			}
			if (flag1 == 0) {
				break;
			}

		}
		System.out.println("\t 4) price");
		double p = 0;

		while (true)

		{
			try {
				p = scanner.nextDouble();
				if (p >= 0) {
					inventory[count].setPrice(p);
					break;
				} else {
					System.out.println("price can only be positive eneter again");
				}

			} catch (Exception e) {
				System.out.println("please enter a only number ");
				scanner.nextLine();

			}

		}

	}

	public static void mainmenu(int maxComputers, int count, Computer[] inventory) {

		Scanner scanner = new Scanner(System.in);
		String PASSWORD = "password";

		String check;

		int option = 0;
		int attempt = 0;
		int number;
		int flag1 = 0;

// Display main menu until enter number between 1-5:

		do {
			System.out.println("What do you want to do?");
			System.out.println("\t 1)Enter new computers (password required)");
			System.out.println("\t 2)Change information of a computer (password required)");
			System.out.println("\t 3)Display all computers by specific brand");
			System.out.println("\t 4)Display all computers under a certain a price");
			System.out.println("\t 5)Quit");
			System.out.print("Please enter your choice> ");

			while (true)

			{
				try {
					option = scanner.nextInt();
					if (option >= 1 && option <= 5) {

						break;
					} else {
						System.out.println("please eneter in range of 1 to 5 ");
					}

				} catch (Exception e) {
					System.out.println("please enter a only a number ");
					scanner.nextLine();

				}

			}
		} while (option < 0 || option > 5);

		switch (option) {
		case 1:

			if (count != maxComputers) {
				attempt = 0;
				do {
					System.out.print("Please, enter your password: \n");
					check = scanner.next();
					attempt++;

					if (check.equals(PASSWORD)) {

						int attempt1 = 0;

//entercomputer info function 

						System.out.println("you could only enter " + (maxComputers - count)
								+ " computers as maximum inventory  limit is " + maxComputers
								+ " and you have already entered " + count);

						while (maxComputers > count) {

							entercomputerinfo(maxComputers, count, inventory);
							count++;
							do {
								System.out.println("enter another computer is yes pres y or Y else press n or N");
								check = scanner.next();
								if (check.equals("y") || check.equals("Y")) {
									System.out.println("nextcomputer info \n");

									break;

								}

								else if (check.equals("n") || check.equals("N")) {
									System.out.println("switch to main menu\n");
									mainmenu(maxComputers, count, inventory);
									break;

								} else
									System.out.println("please input y or n or Y or N\n");
							} while (true);

							if ((maxComputers - count) == 0) {
								System.out.println("inventory is already full. switching to main menu\n");

								mainmenu(maxComputers, count, inventory);
								break;
							}

						}

					}

					else {
						System.out.println("password not correct you have " + (3 - attempt) + " more attempts\n");

						if (attempt == 3) {
							System.out.println("exiting to main menu \n");
							mainmenu(maxComputers, count, inventory);

						}

					}

				} while (attempt < 3);
			} else {
				System.out.println("maximum inventory limit reached limit already reached.switch to main menu");
				mainmenu(maxComputers, count, inventory);
			}
			break;

		case 2:
			attempt = 0;
			if (count == 0) {
				System.out.println(
						"no computers entered in inventory.Please fill the inventory first before updation\n ");
				System.out.println("switching to main menu");
				mainmenu(maxComputers, count, inventory);
			} else {

				do {
					attempt++;
					System.out.println("Please, enter your password: ");
					check = scanner.next();
					if (check.equals(PASSWORD)) {
						System.out.print("Enter the index number of computer u want to update  ");
						while (true)

						{
							try {
								number = scanner.nextInt();
								if (number >= 0) {

									break;
								} else {
									System.out.println("index cannot be negative  ");
								}

							} catch (Exception e) {
								System.out.println("please enter a only a number as an index ");
								scanner.nextLine();

							}

						}

						if (number >= count) {
							if (count == maxComputers) {
								System.out.print(
										"maximum inventory limit reached canot add more computers and entered index"
												+ number + "exceeds the value of inventory limit which is "
												+ maxComputers + " \n");
								mainmenu(maxComputers, count, inventory);
							} else {
								do {
									System.out.println(
											"Index doesnot exist but inventory is not full so u can add computer  .To enter another computer press  press y or Y else press n or N to switch to main menu ");
									check = scanner.next();
									if (check.equals("y") || check.equals("Y")) {
										count++;
										entercomputerinfo(maxComputers, count, inventory);

										System.out
												.println("computer added at index " + count + "switch to main menu\n");

										mainmenu(maxComputers, count, inventory);

										break;

									}

									else if (check.equals("n") || check.equals("N")) {
										System.out.println("switch to main menu\n");
										mainmenu(maxComputers, count, inventory);
										break;

									} else
										System.out.println("please input y or n or Y or N");
								} while (true);
							}

						} else {
							System.out.print("computer index exist  ");

							System.out.print("Enter the attribute u want to update  ");
							do {
								System.out.println("What do you want to do?");
								System.out.println("\t1. 1) Brand");

								System.out.println("\t2. 2)Model");

								System.out.println("\t3. 3)SN");

								System.out.println("\t4. 4) price");

								System.out.println("\t5. Quit");

								while (true)

								{
									try {
										option = scanner.nextInt();
										if (option >= 1 && option <= 5) {

											break;
										} else {
											System.out.println("please enter in range of 1 to 5 ");
										}

									} catch (Exception e) {
										System.out.println("please enter a only a number ");
										scanner.nextLine();

									}

								}

								if (option == 1) {
									System.out.print("update brand\n");
									inventory[number].setBrand(scanner.next());
								}
								if (option == 2) {
									System.out.print("update model \n");
									inventory[number].setModel(scanner.next());

								}
								if (option == 3) {
									while (true) {
										flag1 = 0;
										System.out.println("\t 3)SN");
										inventory[number].setSN(scanner.next());
										for (int i = 0; i < count; i++) {
											if (i != number) {
												if ((inventory[number].getBrand().equals(inventory[i].getBrand()))
														&& (inventory[number].getSN().equals(inventory[i].getSN()))) {
													System.out.println(
															"serial number for that particular brand already exist.enter another one ");
													flag1 = 1;

												}
											}

										}
										if (flag1 == 0) {
											break;
										}

									}
								}
								if (option == 4) {
									System.out.print("Update Price \n");
									inventory[number].setPrice(scanner.nextDouble());

								}
								if (option == 5) {
									System.out.print("main menu switch \n");
									mainmenu(maxComputers, count, inventory);
									;

								}

							} while (option != 5);

						}
						break;
					} else {
						System.out.println("password not correct you have " + (3 - attempt) + " more attempts\n");

						if (attempt == 3) {
							System.out.println("exiting to main menu \n");
							mainmenu(maxComputers, count, inventory);

						}

					}

				} while (attempt < 3);
			}
			break;

		case 3:
			if (count == 0) {
				System.out.print("initialise inventory first before entering this option.Switching to main menu\n");
				mainmenu(maxComputers, count, inventory);
			} else {
				System.out.print("Please, enter a brand name  ");
				check = scanner.next();
				findcomputersby(check, maxComputers, count, inventory);
			}

			break;

		case 4:
			if (count == 0) {
				System.out.print("initialise inventory first before entering this option.Switching to main menu\n");
				mainmenu(maxComputers, count, inventory);
			} else {
				int maxprice;
				System.out.print("Please, enter a price  ");
				maxprice = scanner.nextInt();
				findCheaperThan(maxprice, maxComputers, count, inventory);

			}
			break;

		case 5:

			for (int i = 0; i < count; i++) {
				displaycomputerinfo(i, maxComputers, count, inventory);

			}
			System.out.print("exiting....... ");
			System.exit(0);
			break;

		default:
			break;
		}

		scanner.close();

	}

	public static void main(String[] args) {

		int maxComputers;
		int count = 0;

		System.out.print("How many computers you wants to contain to your inventory: ");
		Scanner scanner1 = new Scanner(System.in);
		while (true)

		{
			try {
				maxComputers = scanner1.nextInt();
				if (maxComputers > 0) {

					break;
				} else if (maxComputers == 0) {
					System.out.println("inventory should contain more than 0 computers ");
				} else {
					System.out.println("please enter positive values as computer number cannot be negative ");
				}

			} catch (Exception e) {
				System.out.println("please enter a only a number ");
				scanner1.nextLine();

			}

		}

		Computer[] inventory = new Computer[maxComputers];
		for (int i = 0; i < maxComputers; i++) {
			inventory[i] = new Computer("", "", "", 0);
		}

		mainmenu(maxComputers, count, inventory);

	}
}
