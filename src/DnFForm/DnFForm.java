package DnFForm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DnFForm extends JFrame {
	private JPanel contentPane;
	private static JTextField textField;
	static String sAPIKey = "WCk6aOMaBRUNunDyDuMidxJFrE56j6R8";
	static String sCharacterID = "";
	private static JTable table, table2, table_2;
	private static DefaultTableModel model, model2;
	private JTable table_1;
	private static JTextField textField_1;
	private static JTextArea textArea;
	private static JScrollPane scrollPane_1 ;
	private static JComboBox comboBox; 
	static String sCommonServerName = "";
	
	static String sServerName[][] = 
		{
		{"안톤", "anton"},
		{"바칼", "bakal"},		
		{"카인", "cain"},
		{"카시야스", "casillas"},
		{"디레지에", "diregie"},
		{"힐더", "hilder"},
		{"프레이", "prey"},
		{"시로코", "siroco"}
};
	private JTable table_3;
	private JTable table_4;
	private JTextField Txt_AdventureName;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DnFForm frame = new DnFForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DnFForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 959, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("서버 : ");
		label.setBounds(12, 10, 42, 15);
		contentPane.add(label);
		
		comboBox = new JComboBox();
		comboBox.setBounds(51, 7, 87, 21);
		
		
		for(int i = 0 ; i < sServerName.length; i++)
		{
			comboBox.addItem(sServerName[i][0]);
		}
		
		contentPane.add(comboBox);
		
		JLabel lblId = new JLabel("케릭터 ID :");
		lblId.setBounds(144, 10, 87, 15);
		contentPane.add(lblId);
		
		textField = new JTextField();
		textField.setBounds(207, 7, 96, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		String columnNames[] =
			{ "날짜", "이름", "채널명", "던전명" };

        model = new DefaultTableModel(null, columnNames);

		table = new JTable(model);
		table.setBounds(12, 10, 343, 211);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.setRowHeight(1, 30);
		
		String columnNames2[] = {"이름", "값"};
		model2 = new DefaultTableModel(null, columnNames2);
		table_2 = new JTable(model2);
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(647, 42, 255, 243);
		scrollPane.setViewportView(table_2);
		
		JScrollPane sc = new JScrollPane(table);
		sc.setBounds(12, 10, 623, 410);
		
		JLabel lblNewLabel = new JLabel("아이템 이름  ");
		lblNewLabel.setBounds(647, 17, 77, 15);
				
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 35, 919, 459);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("에픽 리스트", null, panel, null);
		panel.setLayout(null);
		
		panel.add(sc);
		panel.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(718, 14, 173, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 31, 417, 284);
		panel_1.add(scrollPane_2);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\uB7AD\uD0B9", "\uCC44\uB110 \uBA85", "\uC5D0\uD53D \uB4DC\uB78D \uD69F\uC218", "\uC5D0\uD53D \uB4DC\uB78D%"
			}
		));
		scrollPane_2.setViewportView(table_3);
				
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(441, 31, 461, 284);
		panel_1.add(scrollPane_3);
		
		table_4 = new JTable();
		table_4.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			
			}
		));
		scrollPane_3.setViewportView(table_4);
		JButton btnNewButton = new JButton("확인");
		panel.add(scrollPane);
		
		JLabel label_1 = new JLabel("아이템 설명");
		label_1.setBounds(647, 296, 77, 15);
		panel.add(label_1);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(647, 311, 255, 109);
		panel.add(scrollPane_1);
		
		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("모험단 정보", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel label_4 = new JLabel("모험단 이름 : ");
		label_4.setBounds(12, 10, 81, 15);
		panel_2.add(label_4);
		
		Txt_AdventureName = new JTextField();
		Txt_AdventureName.setBounds(99, 7, 116, 21);
		panel_2.add(Txt_AdventureName);
		Txt_AdventureName.setColumns(10);
		btnNewButton.setBounds(311, 6, 73, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				firstSearch();
				String sUrl = "https://api.neople.co.kr/df/servers/" + sCommonServerName + "/characters/";
						sUrl += sCharacterID ;
						sUrl += "?apikey=" + sAPIKey;
						System.out.println("=="+sUrl);
				//adventureName":"","
				String sDetailInfo = enter(sUrl);
	        	Txt_AdventureName.setText(sDetailInfo.replaceAll(".+?adventureName\":\"|\",\".*", ""));
//	        	"jobGrowId":"15ce2751ab9c8302f39636cdb7c3dcfa","jobName":" ","jobGrowName":" ","adventureName":" ","guildId":"8be7bbf39456357f95388b8febba6606","guildName":" "}

			}
		});
		
		
		table.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{				
				getEpicInfo();
			}
		});
	}
	
	public static void firstSearch()
	{
		String sServerNameEng = sServerName[comboBox.getSelectedIndex()][1];
		sCommonServerName = sServerNameEng; 
		String sName = textField.getText();
		
		textArea.setText("");
		model2 = (DefaultTableModel)table_2.getModel();
		model2.setNumRows(0);
		textField_1.setText("");
		
		if(sName.equals(""))
		{
			JOptionPane.showMessageDialog(null, "캐릭터 ID를 입력해주세요.");
		}
		else
		{
			model = (DefaultTableModel)table.getModel();
			model.setNumRows(0);

			sName = URLEncoder.encode(sName);
			sCharacterID = getCharacterInfo(sServerNameEng, sName);
			
			String sUrl = "https://api.neople.co.kr/df/servers/"+
					 	sServerNameEng
				        +"/characters/"+
				        sCharacterID
				        +"/timeline?limit="
				        + 100 +
				        "&code=504,505,506,507,508&apikey=" + sAPIKey;
			
        	getEpicList(enter(sUrl));
        	
        	String sChneelEpic[] = new String[100];
        	for(int i = 0; i < table.getRowCount(); i++)
        	{
        		//table.getModel().getValueAt(table.getSelectedRow(), 1)
        	//	if()
        	//	table.getModel().getValueAt(table.getSelectedRow(), 1);
        	}
		}
	}
	
	public static String enter(String sCharacterURL)
	{
		URL url = null;
		StringBuilder result = new StringBuilder();
		try
		{
			url = new URL(sCharacterURL);
		
			InputStream in = url.openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			String line;
			while((line = reader.readLine()) != null) {
			    result.append(line);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

		return result.toString();
	}
	
	
	public static String getCharacterInfo(String sServerNameEng, String sName)
	{
		String sCharacterIDTemp = "";
		String sCharacterURL = "https://api.neople.co.kr/df/servers/"+
		sServerNameEng
		+ "/characters?characterName=" +
		sName
		+"&limit=10&wordType=" + 
		"match" 
		+"&apikey=" + sAPIKey;
		String jsonStr = enter(sCharacterURL);
		
		try
		{
			JSONParser jsonParser = new JSONParser();
	        JSONObject jsonObj = (JSONObject) jsonParser.parse(jsonStr);
	        JSONArray memberArray = (JSONArray) jsonObj.get("rows");
	        
	        if(!jsonObj.get("rows").toString().trim().equals("[]"))
	        {
		        for(int i=0 ; i<memberArray.size() ; i++)
		        {
		            JSONObject tempObj = (JSONObject) memberArray.get(i);
		            sCharacterIDTemp = tempObj.get("characterId").toString();//ID �뼸湲�
		            System.out.println(""+(i+1)+"ID : "+tempObj.get("characterId"));
		            System.out.println("캐릭터이름: "+tempObj.get("characterName"));
		            System.out.println("레벨 : "+tempObj.get("level"));
		            System.out.println("직업 : "+tempObj.get("jobName")+ " (" + tempObj.get("jobGrowName") + ")");
		            
		            System.out.println("----------------------------");
		        }
	        }
	        else
	        {
	        	JOptionPane.showMessageDialog(null, "존재하지 않은 캐릭터명입니다.");
	        }
		}
		catch(Exception e1){System.out.println(e1+"==");System.out.println(e1+"==");}
		
		return sCharacterIDTemp;
	}
	
	
	public static void getEpicInfo()
	{
		String sItemName = table.getModel().getValueAt(table.getSelectedRow(), 1).toString();
    	System.out.println(sItemName);
    	String sDecodeItemName = sItemName;
    	sItemName = URLEncoder.encode(sItemName);
		String sUrl = "https://api.neople.co.kr/df/items?itemName=" + sItemName + "&apikey=" + sAPIKey;
    	String sItemID = enter(sUrl).replaceAll(".+?\"itemId\":\"|\",\".*", "");
    	JSONParser parser = new JSONParser();
    	String json = enter("https://api.neople.co.kr/df/items/" + sItemID + "?apikey=" + sAPIKey);
    	
    	model2 = (DefaultTableModel)table_2.getModel();
		model2.setNumRows(0);
		textField_1.setText(sDecodeItemName);
		
    	try
    	{
        	JSONObject univ = (JSONObject)parser.parse(json);
        	JSONArray arr = (JSONArray)univ.get("itemStatus");
        	String arr1 = json.replaceAll(".+?\"itemExplain\":\"|\",.*", ""); 
        	String[] sStrArray = new String[2];
        	
        	arr1 = arr1.toString().replace("\\n", "\n");
        	
        	textArea.setText(arr1.toString());
        	scrollPane_1.getVerticalScrollBar().setValue(0);
        	
        	String sArrayClean[][] =
    		{
        			{"레벨", "itemAvailableLevel"}
        			,{"종류", "itemType"}
        			,{"분류", "itemTypeDetail"}
        	} ;
        	
        	for(int i = 0;i<sArrayClean.length;i++)
        	{
        		sStrArray[0] = sArrayClean[i][0];
        		sStrArray[1] = json.replaceAll(".+?\""+ sArrayClean[i][1] +"\":|,.*|\"", "");
        		model2.addRow(sStrArray);
        	}
        	
        	for(int i=0;i<arr.size();i++)
        	{
    			JSONObject tmp = (JSONObject)arr.get(i);
    			
    			sStrArray[0] = (String)tmp.get("name");
    			sStrArray[1] = (String)tmp.get("value").toString();
    			
    			model2.addRow(sStrArray);
    		}
    	}
    	catch(Exception e5){System.out.println(e5);}
	}
	
	
	public static void getEpicList(String jsonStr)
	{
		try
		{
			JSONParser jsonParser = new JSONParser();
	        JSONObject jsonObj = (JSONObject) jsonParser.parse(jsonStr);
	        jsonObj = (JSONObject) jsonParser.parse(jsonObj.get("timeline").toString());
	        JSONArray memberArray = (JSONArray) jsonObj.get("rows");

	        if(!jsonObj.get("rows").toString().trim().equals("[]"))
	        {
				//System.out.println("=====결과=====");
				
				for(int i=0;i<memberArray.size();i++)
				{
					String sStr = memberArray.get(i).toString();
					System.out.println("중요데이터 : " + sStr);
					String sDate = sStr.replaceAll(".+?date\":\"|\".+","");
					String sOptionName = sStr.replaceAll(".+?\"name\":\"에픽\\s아이템\\s획득|\".*","");
					String sItemName = sStr.replaceAll(".+?itemName\":\"|\".*","");
					String sChannelName1 = sStr.replaceAll(".+?\"channelName\":\"|\",.*","");
					String sChannelName2 = sStr.replaceAll(".+?\"channelNo\":|,.*","");
					String sDeungeon = sStr.replaceAll(".+?\"dungeonName\":\"|\".*","");
					//        "dungeonName" : "던전명"
					String sDataArr[] = new String[4];
					
					sOptionName = sOptionName.replaceAll("\\(|\\)", "");
					sDataArr[0] = sDate; //??
					sDataArr[1] = sItemName; //??
					
					if(sOptionName.equals("지옥 파티"))
					{
						sDataArr[2] = sChannelName1 + " - " + sChannelName2; //지옥 파티
						sDataArr[3] = sDeungeon;
					}
					else
					{
						sDataArr[2] = sOptionName;
					}
					
					model.addRow(sDataArr);
					table.setRowHeight(i, 20);
				}
	        }
	        else
	        {
	        	System.out.println("먹은에픽 존재안함.");
	        }
		}
		catch(Exception e1){System.out.println(e1+"==");System.out.println(e1+"==");}
	}
}
