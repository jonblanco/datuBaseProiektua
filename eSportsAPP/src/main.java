

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Scanner;



public class main {
	private BufferedReader br;
	private Connection konexioa;
	
	public main() {
		konektatu();
		br = new BufferedReader(new InputStreamReader(System.in));		
	}
	
	private void konektatu(){
		try {
			// TODO - datu-basera konektatzeko kodea
			Class.forName("com.mysql.jdbc.Driver");
			String zerbitzaria= "jdbc:mysql://localhost:3306/esportsapp";
			String erabiltzailea= "root";
			String pasahitza="";
			konexioa = DriverManager.getConnection(zerbitzaria, erabiltzailea, pasahitza);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private void menuaErakutsi() throws NumberFormatException, IOException, SQLException{
		int aukera = -1;
		while(aukera!=0){
			System.out.println("\nMenua");
			System.out.println("1.- Jokalari berria sartu");
			System.out.println("2.- Partida berria sartu");
			System.out.println("3.- Jokalari guztiak erakutsi");
			System.out.println("4.- Jokalariak abizenez bilatu");
			System.out.println("0.- Irten");
			aukera=Integer.parseInt(br.readLine());
			if(aukera==1) jokalariBerria();
			else if(aukera==2) partidaBerria();
			else if(aukera==3) jokalariGuztiak();
			else if(aukera==4) jokalariAbizenagatik();
		}
		konexioa.close();
	}
	
	private void jokalariBerria() throws NumberFormatException, IOException, SQLException{
		
		System.out.println("Sartu jokalariaren NAN-a");
		int nan= Integer.parseInt(br.readLine());
		System.out.println("Sartu jokal ariaren Izena-a");
		
		String izena = br.readLine();
		
		System.out.println("Sartu jokalariaren Abizena-a");

		String abizena= br.readLine();
		
		String kontsulta="INSERT INTO JOKALARI(NAN, IZENA, ABIZENA ) VALUES (?,?,?)";
		PreparedStatement pStatement=konexioa.prepareStatement(kontsulta);
		pStatement.setInt(1, nan);
		pStatement.setString(2, izena);
		pStatement.setString(3, abizena);
		pStatement.executeUpdate();
	}
	
	private void partidaBerria() throws SQLException, NumberFormatException, IOException{
		
	
		System.out.println("Sartu jokalariaren NAN-a");
		int nan= Integer.parseInt(br.readLine());
		System.out.println("Sartu partidaren kodea");
		int kodea=Integer.parseInt(br.readLine());
		System.out.println("Sartu eguna");
		String eguna= br.readLine();
		System.out.println("Sartu partidaren iraupena minututan");
		String iraupena= br.readLine();
		System.out.println("Sartu jokalariaren puntuazioa");
		int puntuaziojok= Integer.parseInt(br.readLine());
		System.out.println("Sartu IA-ren puntuazioa");
		String puntuazioaIA= br.readLine();
		
		
		String kontsulta = "INSERT INTO PARTIDA(NAN, KODEA, EGUNA, IRAUPENA, PUNTUAZIOJOK, PUNTUAZIOIA) VALUES(?,?,?,?,?,?)";
		PreparedStatement pStatement=konexioa.prepareStatement(kontsulta);
		pStatement.setInt(1, nan);
		pStatement.setInt(2, kodea);
		pStatement.setString(3, eguna);
		pStatement.setString(4, iraupena);
		pStatement.setInt(5, puntuaziojok);
		pStatement.setString(6, puntuazioaIA);

		pStatement.executeUpdate();
		
		
	}
	
	private void jokalariGuztiak() throws SQLException, IOException{
		// TODO - 3. aukera
		// Jokalari guztiak erakutsi
		
		String kontsulta = "SELECT * FROM JOKALARI";
		PreparedStatement pStatement=konexioa.prepareStatement(kontsulta);

		ResultSet rs = pStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString("Izena"));
		}
	}
		
	private void jokalariAbizenagatik() throws SQLException, IOException{
		// TODO - 4. aukera
		// Teklatutik abizena irakurri eta abizen horri duten jokalari guztiak erakutsi
		
		System.out.println("Sartu ikusi nahi duzun jokalariaren abizena");
		String abizen= br.readLine();
		
		
		String kontsulta = "SELECT * FROM JOKALARI WHERE ABIZENA=?";
		PreparedStatement pStatement=konexioa.prepareStatement(kontsulta);
		pStatement.setString(1, abizen);
		ResultSet rs = pStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString("Izena"));
		}
	}


	
		

	public static void main(String[] args) throws NumberFormatException, IOException, SQLException {
		
		main js = new main();
		ongiEtorriPanel oePanela = new ongiEtorriPanel();
		oePanela.main(null);
	}
}