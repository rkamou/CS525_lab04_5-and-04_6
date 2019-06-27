package lab04_5;
public class Application
{
	Domain domain;
	UI ui;

	public Application()
	{
		domain = new Domain();
		ui = new UI();
	}

	public static void main(String args[])
	{
		new Application();
	}

}
