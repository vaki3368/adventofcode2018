package adventofcode2018;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Day10 {

	public static class Points extends JPanel {

		private List<Point> allPoints;
		
		  public void paintComponent(Graphics g) {
		    super.paintComponent(g);

		    Graphics2D g2d = (Graphics2D) g;

		    g2d.setColor(Color.red);

			Iterator<Point> iterator = allPoints.iterator();
			while(iterator.hasNext()) {
				Point point = iterator.next();
				//g2d.drawLine( (int)point.x + 5, (int)point.y + 5);
				g2d.drawOval((int)point.x, (int)point.y, 1, 1);
			}
		  }

		  public Points(List<Point> points) {
			  allPoints = points;
		    JFrame frame = new JFrame("Points");
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.add(this);
		    frame.setSize(1250, 1200);
		    frame.setLocationRelativeTo(null);
		    frame.setVisible(true);
		  }
		}
	
	private static class Point {
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

		public Point(String line) {
			String[] lineContent = line.replaceAll("position=<", "")
					.replaceAll("> velocity=<", ",").replaceAll(">", "").replaceAll(" ", "").split(",");
			this.x = Long.parseLong(lineContent[0].replaceAll(",", ""));
			this.y = Long.parseLong(lineContent[1].replaceAll(",", ""));
			this.velocityX = Long.parseLong(lineContent[2].replaceAll(",", ""));
			this.velocityY = Long.parseLong(lineContent[3].replaceAll(",", ""));
		}
		long x;
		long y;
		long velocityX;
		long velocityY;
		
		public void tick() {
			x += velocityX;
			y += velocityY;
		}
	}

	public static void main(String[] args) {
		String[] lines = input.split("\\n");
		List<Point> allPoints = new LinkedList<>();
		for (String line : lines) {
			allPoints.add(new Point(line));
		}
		
		// TODO find minimal distance between points
		// its 10710
		
		for (int i = 0; i < 10710; i++) {
			Iterator<Point> iterator = allPoints.iterator();
			while(iterator.hasNext()) {
				iterator.next().tick();
			}
		}
		
		new Points(allPoints);
		System.out.println();
		
	}
	
	private final static String input = "position=<-42601, -53357> velocity=< 4,  5>\n" + 
			"position=< 10946,  43042> velocity=<-1, -4>\n" + 
			"position=< 21657,  32332> velocity=<-2, -3>\n" + 
			"position=<-42617,  53749> velocity=< 4, -5>\n" + 
			"position=<-21225, -53349> velocity=< 2,  5>\n" + 
			"position=< 10929, -42647> velocity=<-1,  4>\n" + 
			"position=< 53758,  43040> velocity=<-5, -4>\n" + 
			"position=< 53745,  21622> velocity=<-5, -2>\n" + 
			"position=<-42602,  32332> velocity=< 4, -3>\n" + 
			"position=< 53741, -42644> velocity=<-5,  4>\n" + 
			"position=< 10918,  21622> velocity=<-1, -2>\n" + 
			"position=< 43075, -31929> velocity=<-4,  3>\n" + 
			"position=< 32320,  21617> velocity=<-3, -2>\n" + 
			"position=<-31914,  32330> velocity=< 3, -3>\n" + 
			"position=<-53311, -42645> velocity=< 5,  4>\n" + 
			"position=<-10491,  10911> velocity=< 1, -1>\n" + 
			"position=< 21628, -21224> velocity=<-2,  2>\n" + 
			"position=<-53355, -31932> velocity=< 5,  3>\n" + 
			"position=< 21644,  32323> velocity=<-2, -3>\n" + 
			"position=< 10925, -53353> velocity=<-1,  5>\n" + 
			"position=< 43039,  32329> velocity=<-4, -3>\n" + 
			"position=<-31919, -31933> velocity=< 3,  3>\n" + 
			"position=<-10502, -10513> velocity=< 1,  1>\n" + 
			"position=< 21659, -53353> velocity=<-2,  5>\n" + 
			"position=<-42609, -21225> velocity=< 4,  2>\n" + 
			"position=<-21181,  43041> velocity=< 2, -4>\n" + 
			"position=<-21201,  21622> velocity=< 2, -2>\n" + 
			"position=<-31911, -42638> velocity=< 3,  4>\n" + 
			"position=<-31919, -31930> velocity=< 3,  3>\n" + 
			"position=<-42596, -31937> velocity=< 4,  3>\n" + 
			"position=< 53737, -42639> velocity=<-5,  4>\n" + 
			"position=< 43072, -10509> velocity=<-4,  1>\n" + 
			"position=<-10467, -31929> velocity=< 1,  3>\n" + 
			"position=< 53789, -42646> velocity=<-5,  4>\n" + 
			"position=<-53311, -42639> velocity=< 5,  4>\n" + 
			"position=< 32373, -42643> velocity=<-3,  4>\n" + 
			"position=< 21618,  43038> velocity=<-2, -4>\n" + 
			"position=<-53342,  10905> velocity=< 5, -1>\n" + 
			"position=< 10918,  43039> velocity=<-1, -4>\n" + 
			"position=<-42621,  43034> velocity=< 4, -4>\n" + 
			"position=<-42624,  43041> velocity=< 4, -4>\n" + 
			"position=<-10487,  43039> velocity=< 1, -4>\n" + 
			"position=< 53749,  43039> velocity=<-5, -4>\n" + 
			"position=< 10916,  53743> velocity=<-1, -5>\n" + 
			"position=<-10486,  43034> velocity=< 1, -4>\n" + 
			"position=< 53761, -42644> velocity=<-5,  4>\n" + 
			"position=< 32351, -10512> velocity=<-3,  1>\n" + 
			"position=<-31916,  32332> velocity=< 3, -3>\n" + 
			"position=< 53754,  43034> velocity=<-5, -4>\n" + 
			"position=< 21631, -42638> velocity=<-2,  4>\n" + 
			"position=< 32344, -10513> velocity=<-3,  1>\n" + 
			"position=< 21655,  43041> velocity=<-2, -4>\n" + 
			"position=< 10958, -31929> velocity=<-1,  3>\n" + 
			"position=< 43061,  32327> velocity=<-4, -3>\n" + 
			"position=< 32373, -31933> velocity=<-3,  3>\n" + 
			"position=<-53305, -31928> velocity=< 5,  3>\n" + 
			"position=<-53327, -42641> velocity=< 5,  4>\n" + 
			"position=<-21221, -10513> velocity=< 2,  1>\n" + 
			"position=< 32369,  53745> velocity=<-3, -5>\n" + 
			"position=<-21204, -53352> velocity=< 2,  5>\n" + 
			"position=< 10921, -42642> velocity=<-1,  4>\n" + 
			"position=<-53307, -10512> velocity=< 5,  1>\n" + 
			"position=< 53798,  10904> velocity=<-5, -1>\n" + 
			"position=<-53336,  32327> velocity=< 5, -3>\n" + 
			"position=<-21177,  21616> velocity=< 2, -2>\n" + 
			"position=< 21623,  21616> velocity=<-2, -2>\n" + 
			"position=< 32351,  10907> velocity=<-3, -1>\n" + 
			"position=<-53350,  21621> velocity=< 5, -2>\n" + 
			"position=< 32346, -21224> velocity=<-3,  2>\n" + 
			"position=< 32335,  21613> velocity=<-3, -2>\n" + 
			"position=<-42652,  21622> velocity=< 4, -2>\n" + 
			"position=< 43035,  32327> velocity=<-4, -3>\n" + 
			"position=<-10471, -31937> velocity=< 1,  3>\n" + 
			"position=< 53772,  32327> velocity=<-5, -3>\n" + 
			"position=<-21225,  32329> velocity=< 2, -3>\n" + 
			"position=< 43051,  53747> velocity=<-4, -5>\n" + 
			"position=< 10934, -31929> velocity=<-1,  3>\n" + 
			"position=<-10467,  32330> velocity=< 1, -3>\n" + 
			"position=<-10502,  10912> velocity=< 1, -1>\n" + 
			"position=< 32341,  32332> velocity=<-3, -3>\n" + 
			"position=< 10908, -53353> velocity=<-1,  5>\n" + 
			"position=< 21623, -42644> velocity=<-2,  4>\n" + 
			"position=<-10478,  32323> velocity=< 1, -3>\n" + 
			"position=< 21620, -53355> velocity=<-2,  5>\n" + 
			"position=< 21627,  21614> velocity=<-2, -2>\n" + 
			"position=<-21192,  10906> velocity=< 2, -1>\n" + 
			"position=< 21631, -53350> velocity=<-2,  5>\n" + 
			"position=< 10930, -10514> velocity=<-1,  1>\n" + 
			"position=< 53789, -42643> velocity=<-5,  4>\n" + 
			"position=< 32335,  10908> velocity=<-3, -1>\n" + 
			"position=< 10930,  32330> velocity=<-1, -3>\n" + 
			"position=< 53748, -21227> velocity=<-5,  2>\n" + 
			"position=< 43080, -10517> velocity=<-4,  1>\n" + 
			"position=< 32358,  32329> velocity=<-3, -3>\n" + 
			"position=<-42601, -10512> velocity=< 4,  1>\n" + 
			"position=< 21666,  43033> velocity=<-2, -4>\n" + 
			"position=<-10515,  53747> velocity=< 1, -5>\n" + 
			"position=<-53352,  53743> velocity=< 5, -5>\n" + 
			"position=<-42616,  53752> velocity=< 4, -5>\n" + 
			"position=<-10513, -53353> velocity=< 1,  5>\n" + 
			"position=<-10487,  32326> velocity=< 1, -3>\n" + 
			"position=< 10954,  43042> velocity=<-1, -4>\n" + 
			"position=< 53753,  43042> velocity=<-5, -4>\n" + 
			"position=<-10487,  10906> velocity=< 1, -1>\n" + 
			"position=<-10515, -53348> velocity=< 1,  5>\n" + 
			"position=< 53761, -21225> velocity=<-5,  2>\n" + 
			"position=< 10913, -42639> velocity=<-1,  4>\n" + 
			"position=<-21217, -10511> velocity=< 2,  1>\n" + 
			"position=< 21623,  21620> velocity=<-2, -2>\n" + 
			"position=< 53763, -21227> velocity=<-5,  2>\n" + 
			"position=< 43043, -21225> velocity=<-4,  2>\n" + 
			"position=< 53746, -31933> velocity=<-5,  3>\n" + 
			"position=<-31943, -31937> velocity=< 3,  3>\n" + 
			"position=< 21608,  53743> velocity=<-2, -5>\n" + 
			"position=<-53344, -10512> velocity=< 5,  1>\n" + 
			"position=< 43048, -42641> velocity=<-4,  4>\n" + 
			"position=<-21225, -53350> velocity=< 2,  5>\n" + 
			"position=< 53758, -31933> velocity=<-5,  3>\n" + 
			"position=< 43079,  32329> velocity=<-4, -3>\n" + 
			"position=< 21636, -31931> velocity=<-2,  3>\n" + 
			"position=< 21611, -31937> velocity=<-2,  3>\n" + 
			"position=<-10471, -10511> velocity=< 1,  1>\n" + 
			"position=<-42616,  53752> velocity=< 4, -5>\n" + 
			"position=< 43036,  32323> velocity=<-4, -3>\n" + 
			"position=<-10466, -31937> velocity=< 1,  3>\n" + 
			"position=<-42609, -10510> velocity=< 4,  1>\n" + 
			"position=< 53773, -21224> velocity=<-5,  2>\n" + 
			"position=<-10507, -10515> velocity=< 1,  1>\n" + 
			"position=<-42632, -31930> velocity=< 4,  3>\n" + 
			"position=<-21190,  32328> velocity=< 2, -3>\n" + 
			"position=<-53338, -42647> velocity=< 5,  4>\n" + 
			"position=< 53741,  10906> velocity=<-5, -1>\n" + 
			"position=<-53305, -10517> velocity=< 5,  1>\n" + 
			"position=<-31885, -10517> velocity=< 3,  1>\n" + 
			"position=<-10523,  53752> velocity=< 1, -5>\n" + 
			"position=< 21611,  10906> velocity=<-2, -1>\n" + 
			"position=<-31892,  32323> velocity=< 3, -3>\n" + 
			"position=< 32318,  32332> velocity=<-3, -3>\n" + 
			"position=<-42632, -53348> velocity=< 4,  5>\n" + 
			"position=< 10918,  43037> velocity=<-1, -4>\n" + 
			"position=<-31903,  53744> velocity=< 3, -5>\n" + 
			"position=<-53318,  21622> velocity=< 5, -2>\n" + 
			"position=< 43037,  32323> velocity=<-4, -3>\n" + 
			"position=<-10499, -53356> velocity=< 1,  5>\n" + 
			"position=<-10504, -31932> velocity=< 1,  3>\n" + 
			"position=< 43075,  10910> velocity=<-4, -1>\n" + 
			"position=< 43068, -10510> velocity=<-4,  1>\n" + 
			"position=<-10499, -21220> velocity=< 1,  2>\n" + 
			"position=<-42650, -10508> velocity=< 4,  1>\n" + 
			"position=<-31892, -31928> velocity=< 3,  3>\n" + 
			"position=<-21189,  43036> velocity=< 2, -4>\n" + 
			"position=< 43076,  53752> velocity=<-4, -5>\n" + 
			"position=<-42620,  21615> velocity=< 4, -2>\n" + 
			"position=<-21177,  32330> velocity=< 2, -3>\n" + 
			"position=< 10937,  43033> velocity=<-1, -4>\n" + 
			"position=<-31898,  21614> velocity=< 3, -2>\n" + 
			"position=< 53739,  10912> velocity=<-5, -1>\n" + 
			"position=<-21206, -53353> velocity=< 2,  5>\n" + 
			"position=<-21228,  21613> velocity=< 2, -2>\n" + 
			"position=< 21609, -31932> velocity=<-2,  3>\n" + 
			"position=<-42613,  21622> velocity=< 4, -2>\n" + 
			"position=<-21177, -53351> velocity=< 2,  5>\n" + 
			"position=<-21207,  21622> velocity=< 2, -2>\n" + 
			"position=< 53761, -10508> velocity=<-5,  1>\n" + 
			"position=< 53740, -31937> velocity=<-5,  3>\n" + 
			"position=< 53756, -31937> velocity=<-5,  3>\n" + 
			"position=<-21192, -21220> velocity=< 2,  2>\n" + 
			"position=<-21174,  43033> velocity=< 2, -4>\n" + 
			"position=<-10511, -53351> velocity=< 1,  5>\n" + 
			"position=< 10900, -42647> velocity=<-1,  4>\n" + 
			"position=<-53352,  21618> velocity=< 5, -2>\n" + 
			"position=< 53798,  10904> velocity=<-5, -1>\n" + 
			"position=< 43079, -53350> velocity=<-4,  5>\n" + 
			"position=<-10498, -21218> velocity=< 1,  2>\n" + 
			"position=< 10909,  10910> velocity=<-1, -1>\n" + 
			"position=<-42613,  32331> velocity=< 4, -3>\n" + 
			"position=<-42644, -21227> velocity=< 4,  2>\n" + 
			"position=<-10510, -42645> velocity=< 1,  4>\n" + 
			"position=<-53334, -21225> velocity=< 5,  2>\n" + 
			"position=< 10918,  53745> velocity=<-1, -5>\n" + 
			"position=< 21633,  53747> velocity=<-2, -5>\n" + 
			"position=<-21205, -21223> velocity=< 2,  2>\n" + 
			"position=< 21640, -10511> velocity=<-2,  1>\n" + 
			"position=<-10503,  10908> velocity=< 1, -1>\n" + 
			"position=<-53322, -10515> velocity=< 5,  1>\n" + 
			"position=< 43076,  43042> velocity=<-4, -4>\n" + 
			"position=<-53312, -53348> velocity=< 5,  5>\n" + 
			"position=< 32333,  10911> velocity=<-3, -1>\n" + 
			"position=< 53761,  32323> velocity=<-5, -3>\n" + 
			"position=<-21173,  21622> velocity=< 2, -2>\n" + 
			"position=< 10918, -21219> velocity=<-1,  2>\n" + 
			"position=< 43069, -53352> velocity=<-4,  5>\n" + 
			"position=<-42608,  21621> velocity=< 4, -2>\n" + 
			"position=<-31938,  53752> velocity=< 3, -5>\n" + 
			"position=<-42653, -21220> velocity=< 4,  2>\n" + 
			"position=< 10905, -10511> velocity=<-1,  1>\n" + 
			"position=<-21204,  43038> velocity=< 2, -4>\n" + 
			"position=< 10925, -31937> velocity=<-1,  3>\n" + 
			"position=< 53781,  53746> velocity=<-5, -5>\n" + 
			"position=<-31906, -31937> velocity=< 3,  3>\n" + 
			"position=< 10929,  10912> velocity=<-1, -1>\n" + 
			"position=<-53346,  21618> velocity=< 5, -2>\n" + 
			"position=<-31919,  21618> velocity=< 3, -2>\n" + 
			"position=< 43083, -21225> velocity=<-4,  2>\n" + 
			"position=< 43027, -42639> velocity=<-4,  4>\n" + 
			"position=<-31916,  53752> velocity=< 3, -5>\n" + 
			"position=< 32333, -10512> velocity=<-3,  1>\n" + 
			"position=<-10487,  32330> velocity=< 1, -3>\n" + 
			"position=< 43056,  53751> velocity=<-4, -5>\n" + 
			"position=<-21189, -53351> velocity=< 2,  5>\n" + 
			"position=< 32333, -31932> velocity=<-3,  3>\n" + 
			"position=< 10905, -21227> velocity=<-1,  2>\n" + 
			"position=< 53795, -31937> velocity=<-5,  3>\n" + 
			"position=<-10490,  43040> velocity=< 1, -4>\n" + 
			"position=< 21647,  21613> velocity=<-2, -2>\n" + 
			"position=< 21616,  10907> velocity=<-2, -1>\n" + 
			"position=<-10499,  10905> velocity=< 1, -1>\n" + 
			"position=<-21232,  53749> velocity=< 2, -5>\n" + 
			"position=<-42645, -31933> velocity=< 4,  3>\n" + 
			"position=<-31927,  43037> velocity=< 3, -4>\n" + 
			"position=<-31942, -31937> velocity=< 3,  3>\n" + 
			"position=< 21620, -53348> velocity=<-2,  5>\n" + 
			"position=< 43054, -42647> velocity=<-4,  4>\n" + 
			"position=< 32329, -42640> velocity=<-3,  4>\n" + 
			"position=<-10486, -21227> velocity=< 1,  2>\n" + 
			"position=< 10929, -10509> velocity=<-1,  1>\n" + 
			"position=< 43051, -31934> velocity=<-4,  3>\n" + 
			"position=< 21666, -42638> velocity=<-2,  4>\n" + 
			"position=<-21228,  32324> velocity=< 2, -3>\n" + 
			"position=<-31899,  21615> velocity=< 3, -2>\n" + 
			"position=< 32338, -42644> velocity=<-3,  4>\n" + 
			"position=<-42624, -31931> velocity=< 4,  3>\n" + 
			"position=<-53319, -21224> velocity=< 5,  2>\n" + 
			"position=<-31911,  43033> velocity=< 3, -4>\n" + 
			"position=<-42608,  53752> velocity=< 4, -5>\n" + 
			"position=< 43064, -31929> velocity=<-4,  3>\n" + 
			"position=<-53350,  32332> velocity=< 5, -3>\n" + 
			"position=<-21212,  21618> velocity=< 2, -2>\n" + 
			"position=< 21620,  43034> velocity=<-2, -4>\n" + 
			"position=<-31887, -42645> velocity=< 3,  4>\n" + 
			"position=< 53738,  10909> velocity=<-5, -1>\n" + 
			"position=< 43067,  43042> velocity=<-4, -4>\n" + 
			"position=< 21643,  43040> velocity=<-2, -4>\n" + 
			"position=<-31924,  32323> velocity=< 3, -3>\n" + 
			"position=< 10930,  53745> velocity=<-1, -5>\n" + 
			"position=< 43027,  43042> velocity=<-4, -4>\n" + 
			"position=< 10917, -21226> velocity=<-1,  2>\n" + 
			"position=<-53363,  10912> velocity=< 5, -1>\n" + 
			"position=<-10502,  32328> velocity=< 1, -3>\n" + 
			"position=< 53749, -42647> velocity=<-5,  4>\n" + 
			"position=<-42597, -31932> velocity=< 4,  3>\n" + 
			"position=<-10522,  43039> velocity=< 1, -4>\n" + 
			"position=< 10907,  10907> velocity=<-1, -1>\n" + 
			"position=< 53755,  21618> velocity=<-5, -2>\n" + 
			"position=< 10941, -53355> velocity=<-1,  5>\n" + 
			"position=< 43087,  53743> velocity=<-4, -5>\n" + 
			"position=<-53355, -31930> velocity=< 5,  3>\n" + 
			"position=< 53740, -21227> velocity=<-5,  2>\n" + 
			"position=<-42628, -21223> velocity=< 4,  2>\n" + 
			"position=< 43029, -42647> velocity=<-4,  4>\n" + 
			"position=<-10518,  32324> velocity=< 1, -3>\n" + 
			"position=<-21204,  43038> velocity=< 2, -4>\n" + 
			"position=<-31891, -53353> velocity=< 3,  5>\n" + 
			"position=< 21636,  10904> velocity=<-2, -1>\n" + 
			"position=<-21217,  10909> velocity=< 2, -1>\n" + 
			"position=<-42651, -42647> velocity=< 4,  4>\n" + 
			"position=< 10950,  32323> velocity=<-1, -3>\n" + 
			"position=<-10512, -21227> velocity=< 1,  2>\n" + 
			"position=<-31933,  43037> velocity=< 3, -4>\n" + 
			"position=<-42624, -10515> velocity=< 4,  1>\n" + 
			"position=< 10949,  10908> velocity=<-1, -1>\n" + 
			"position=< 32325,  32329> velocity=<-3, -3>\n" + 
			"position=< 10942, -21226> velocity=<-1,  2>\n" + 
			"position=< 53798,  43034> velocity=<-5, -4>\n" + 
			"position=< 10930,  32326> velocity=<-1, -3>\n" + 
			"position=< 10898,  21622> velocity=<-1, -2>\n" + 
			"position=< 43080,  10903> velocity=<-4, -1>\n" + 
			"position=< 43027, -42639> velocity=<-4,  4>\n" + 
			"position=< 10949,  43036> velocity=<-1, -4>\n" + 
			"position=< 10926, -31936> velocity=<-1,  3>\n" + 
			"position=< 21628, -21222> velocity=<-2,  2>\n" + 
			"position=< 10949, -31934> velocity=<-1,  3>\n" + 
			"position=< 10923, -53357> velocity=<-1,  5>\n" + 
			"position=<-53346,  32324> velocity=< 5, -3>\n" + 
			"position=<-21193,  21614> velocity=< 2, -2>\n" + 
			"position=<-10467,  32326> velocity=< 1, -3>\n" + 
			"position=<-53331,  43034> velocity=< 5, -4>\n" + 
			"position=< 32325, -42646> velocity=<-3,  4>\n" + 
			"position=< 21620,  53745> velocity=<-2, -5>\n" + 
			"position=< 10902, -21225> velocity=<-1,  2>\n" + 
			"position=< 43060,  10905> velocity=<-4, -1>\n" + 
			"position=<-53339, -10516> velocity=< 5,  1>\n" + 
			"position=<-42644,  10903> velocity=< 4, -1>\n" + 
			"position=< 43069, -53353> velocity=<-4,  5>\n" + 
			"position=< 21663, -42643> velocity=<-2,  4>\n" + 
			"position=< 10949,  10908> velocity=<-1, -1>\n" + 
			"position=< 53796, -21227> velocity=<-5,  2>\n" + 
			"position=<-10515, -31934> velocity=< 1,  3>\n" + 
			"position=< 10897, -31937> velocity=<-1,  3>\n" + 
			"position=< 53745,  43034> velocity=<-5, -4>\n" + 
			"position=< 10937,  43033> velocity=<-1, -4>\n" + 
			"position=<-53319,  10910> velocity=< 5, -1>\n" + 
			"position=<-53346, -53356> velocity=< 5,  5>\n" + 
			"position=<-31938,  43033> velocity=< 3, -4>\n" + 
			"position=<-31940, -31933> velocity=< 3,  3>\n" + 
			"position=< 53779, -31933> velocity=<-5,  3>\n" + 
			"position=<-42629,  10903> velocity=< 4, -1>\n" + 
			"position=<-21205, -21218> velocity=< 2,  2>\n" + 
			"position=<-31900,  32327> velocity=< 3, -3>\n" + 
			"position=< 10900, -10508> velocity=<-1,  1>\n" + 
			"position=<-42632,  43040> velocity=< 4, -4>\n" + 
			"position=<-31933,  21613> velocity=< 3, -2>\n" + 
			"position=<-10495, -31933> velocity=< 1,  3>\n" + 
			"position=<-42627,  10903> velocity=< 4, -1>\n" + 
			"position=<-42629, -21226> velocity=< 4,  2>\n" + 
			"position=<-42626, -42638> velocity=< 4,  4>\n" + 
			"position=< 10921, -21225> velocity=<-1,  2>\n" + 
			"position=< 43039,  21620> velocity=<-4, -2>\n" + 
			"position=< 21647,  43041> velocity=<-2, -4>\n" + 
			"position=< 21626,  43038> velocity=<-2, -4>\n" + 
			"position=< 43062,  32328> velocity=<-4, -3>\n" + 
			"position=<-21229, -21218> velocity=< 2,  2>\n" + 
			"position=< 43031, -53348> velocity=<-4,  5>\n" + 
			"position=< 43060,  21620> velocity=<-4, -2>\n" + 
			"position=<-53312,  32323> velocity=< 5, -3>\n" + 
			"position=<-42626, -42647> velocity=< 4,  4>\n" + 
			"position=< 43059,  32323> velocity=<-4, -3>\n" + 
			"position=<-31940, -21218> velocity=< 3,  2>\n" + 
			"position=< 53753, -10514> velocity=<-5,  1>\n" + 
			"position=< 32349, -10516> velocity=<-3,  1>\n" + 
			"position=< 32341,  32331> velocity=<-3, -3>\n" + 
			"position=< 43048, -21219> velocity=<-4,  2>\n" + 
			"position=< 10941, -10510> velocity=<-1,  1>\n" + 
			"position=< 43035,  10903> velocity=<-4, -1>\n" + 
			"position=< 10942, -21219> velocity=<-1,  2>\n" + 
			"position=< 21652, -42638> velocity=<-2,  4>\n" + 
			"position=<-53351,  21617> velocity=< 5, -2>\n" + 
			"position=<-21213,  10904> velocity=< 2, -1>\n" + 
			"position=<-53355, -21225> velocity=< 5,  2>\n" + 
			"position=<-21193, -10508> velocity=< 2,  1>\n" + 
			"position=< 43035,  53743> velocity=<-4, -5>\n" + 
			"position=<-42628,  53747> velocity=< 4, -5>\n" + 
			"position=< 53750, -31934> velocity=<-5,  3>\n" + 
			"position=< 53778,  53750> velocity=<-5, -5>\n" + 
			"position=<-53338,  32323> velocity=< 5, -3>\n" + 
			"position=<-53358, -31937> velocity=< 5,  3>\n" + 
			"position=< 21663, -31936> velocity=<-2,  3>\n" + 
			"position=<-21209,  43037> velocity=< 2, -4>\n" + 
			"position=<-10467,  32328> velocity=< 1, -3>\n" + 
			"position=<-21173,  21613> velocity=< 2, -2>\n" + 
			"position=< 10899,  10908> velocity=<-1, -1>\n" + 
			"position=<-31935, -31932> velocity=< 3,  3>\n" + 
			"position=< 21643, -42640> velocity=<-2,  4>\n" + 
			"position=< 21651,  43039> velocity=<-2, -4>\n" + 
			"position=<-42628,  21622> velocity=< 4, -2>\n" + 
			"position=< 10926, -10515> velocity=<-1,  1>\n" + 
			"position=< 32335,  43038> velocity=<-3, -4>\n" + 
			"position=< 53773,  10905> velocity=<-5, -1>\n" + 
			"position=<-31939, -53357> velocity=< 3,  5>\n" + 
			"position=<-42643,  53743> velocity=< 4, -5>\n" + 
			"position=<-21199,  21617> velocity=< 2, -2>\n" + 
			"position=<-10499, -31931> velocity=< 1,  3>\n";

}
