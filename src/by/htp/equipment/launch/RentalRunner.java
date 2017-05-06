package by.htp.equipment.launch;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.HandlerBase;
import org.xml.sax.SAXException;

import by.htp.equipment.builder.AbstractEquipmentsBuilder;
import by.htp.equipment.builder.EquipmentBuilderFactory;
import by.htp.equipment.entity.Accessory;
import by.htp.equipment.entity.Bycicle;
import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.Helmet;
import by.htp.equipment.entity.MaterialEnum;
import by.htp.equipment.entity.Order;
import by.htp.equipment.entity.Person;
import by.htp.equipment.entity.PersonCategoryEnum;
import by.htp.equipment.entity.Skate;
import by.htp.equipment.logic.OrderDB;
import by.htp.equipment.logic.RentStation;
import by.htp.equipment.logic.RentalManager;
import by.htp.equipment.logic.Search;
import by.htp.equipment.writer.Printer;

public class RentalRunner {
	
	
	public RentalManager mainRunner() throws ClassNotFoundException {
		RentStation rentStation = new RentStation();

		addEquipmentsFromXML(rentStation);
		RentalManager rentalManager = start(rentStation);
		
		return rentalManager;
	}
	
	private void addEquipmentsFromXML(RentStation rentStation) {
		
		//isXMLAccordingWithXSD();
		startParser("stax", rentStation); // "sax", "dom", "stax"
	}
	
	private void startParser(String parserType, RentStation rentStation) {
		EquipmentBuilderFactory sFactory = new EquipmentBuilderFactory();
		AbstractEquipmentsBuilder builder = sFactory.createEquipmentBuilder(parserType);
		builder.buildListEquipments(XMLFilePath);
		List<Equipment> equipments = builder.getEquipments();
		
		for (Equipment  eq : equipments) {
			//System.out.println(eq);
			rentStation.addEquipment(eq);
		}
	}
	
	private void isXMLAccordingWithXSD() {
		String filename = XMLFilePath;
		String schemaname = "D:\\java\\JD1\\rental\\resource\\equipmentsSchema.xsd";
		String logname = "D:\\java\\JD1\\rental\\resource\\log.txt";
		Schema schema = null;
		String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
		SchemaFactory factory = SchemaFactory.newInstance(language);
		try {
			// установка проверки с использованием XSD
			schema = factory.newSchema(new File(schemaname));
			SAXParserFactory spf = SAXParserFactory.newInstance();
			spf.setSchema(schema);
			// создание объекта-парсера
			SAXParser parser = spf.newSAXParser();
			// установка обработчика ошибок и запуск
			parser.parse(filename, new HandlerBase());
			System.out.println(filename + " is valid");
		} catch (ParserConfigurationException e) {
			System.err.println(filename + " config error: " + e.getMessage());
		} catch (SAXException e) {
			System.err.println(filename + " SAX error: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("I/O error: " + e.getMessage());
		}
	}
	
	private RentalManager start(RentStation rentStation) throws ClassNotFoundException {

		Printer print = new Printer();
		
		//print.printRes("All Equipments", rentStation);
		//print.printRes("All spare equipments:", rentStation.getSpareEquipments());
		//print.printRes("All engaged equipments:", rentStation.getEngagedEquipments());
		
		Person person1 = new Person("Ivan", "Ivanov", "12345678");
		
		OrderDB orderDB = new OrderDB();
		RentalManager rentalManager = new RentalManager(rentStation, orderDB);
		
		//  Create order for person //
		//System.out.println("Create order");
		rentalManager.resetEquipments();
		Equipment equipmentForRent = Search.findSpareEquipmentByType(rentStation, "Bycicle");
		if ( equipmentForRent != null ) {
			Order order1 = new Order(person1, equipmentForRent, 24);
			boolean resRent1 = rentalManager.rent(order1);
			//String printInf = ( resRent1 ? "Equipment was added" : "Equipment wasn't added" );
			//print.printRes(printInf);
		}
		
		//print.printRes("spare=", rentStation.getSpareEquipments());
		//print.printRes("engaged=", rentStation.getEngagedEquipments());
		//System.out.print(orderDB.getUnits());
		
		////////////////////////////////
		rentalManager.resetEquipments();
		Equipment equipmentForRent2 = Search.findSpareEquipmentByType(rentStation, "Bycicle");
		if ( equipmentForRent2 != null ) {
			Order order2 = new Order(person1, equipmentForRent2, 12);
			boolean resRent2 = rentalManager.rent(order2);
			//String printInf = ( resRent2 ? "Equipment was added" : "Equipment wasn't added" );
			//print.printRes(printInf);
		}
		
		//print.printRes("spare=", rentStation.getSpareEquipments());
		//print.printRes("engaged=", rentStation.getEngagedEquipments());
		//System.out.print(orderDB.getUnits());
		
		////   find equipment by params
		//rentalManager.resetEquipments();
		//print.printRes("There are founded equipments", Search.findEquipmentByParams(rentStation, 40));
		
		//print.printRes("There are founded equipments by last hour");
		//findInformation(rentalManager);
		
		return rentalManager;
	}
}
