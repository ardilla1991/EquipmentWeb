package by.htp.equipment.builder;

import java.io.IOException;
import java.util.List;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.htp.equipment.entity.Equipment;

public class EquipmentSAXBuilder extends AbstractEquipmentsBuilder{
	private List<Equipment> eq;
	private EquipmentSAXHandler sh;
	private XMLReader reader;
	
	public EquipmentSAXBuilder() {

		sh = new EquipmentSAXHandler();
		try {
			// �������� �������-�����������
			reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(sh);
			
			//��������� �������� ����������������
			reader.setFeature("http://xml.org/sax/features/validation", true);
			
			//��������� ��������� ������������ ����
			reader.setFeature("http://xml.org/sax/features/namespaces", true);
			
			//��������� ����������� �����
			reader.setFeature("http://xml.org/sax/features/string-interning", true);
			
			//���������� ��������� ����
			//reader.setFeature("http://xml.org/sax/features/validation/schema", false);
			
		} catch (SAXException e) {
			System.err.print("������ SAX �������: " + e);
		}
	}
	
	public List<Equipment> getEquipments() {
		return eq;
	}
	
	public void buildListEquipments(String fileName) {
		try {
			// ������ XML-���������
			reader.parse(fileName);
		} catch (SAXException e) {
			System.err.print("������ SAX �������: " + e);
		} catch (IOException e) {
			System.err.print("������ I/� ������: " + e);
		}
		eq = sh.getEquipmentList();
	}
}
