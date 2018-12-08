package adventofcode2018;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

public class Day2  {

	public static void main(String[] args) {
		
		List<String> list = Lists.newArrayList(Splitter.on("\n").split(input));
		int exactly2 = 0;
		int exactly3 = 0;
		
		for(String element : list) {
			Map<String, Integer> map = new HashMap<>();
			char[] charArray = element.toCharArray();
			for(int i = 0; i < charArray.length; i++) {
				String key = Character.toString(charArray[i]);
				Integer value = map.get(key);
				if(value == null) {
					map.put(key, 1);
				}
				else {
					map.put(key, value + 1);
				}				
			}
			Set<Integer> lettersSet = new HashSet<>(map.values());
			for(Integer intValue: lettersSet) {
				if(intValue == 2) {
					exactly2++;
				}
				else if(intValue == 3) {
					exactly3++;
				}
			}
		}
		System.out.println("2=" + exactly2 + ", 3=" + exactly3 + ", sum= " + (exactly2 * exactly3));
		
		// part 2
		for (int i = 0; i < list.size(); i++) {
			String string1 = list.get(i);
			for (int j = i + 1; j < list.size() - 1; j++) {
				String string2 = list.get(j);
				int differencies = 0;
				for (int k = 0; k < string1.length() - 1; k++) {
					if (string1.charAt(k) != string2.charAt(k)) {
						differencies++;
					}
					if (differencies > 1)
						break;
				}
				if(differencies < 2) { // found
					System.out.println(string1 + " : " + string2);
					System.out.print("diff: ");
					for (int k = 0; k < string1.length() - 1; k++) {
						if (string1.charAt(k) == string2.charAt(k)) {
							System.out.print(string1.charAt(k));
						}
					}
					
				}	
			}
		}
		
	}

	private static final String input = "ivyhczwokexltwhsfamqprbnuy\n" + 
			"ivjhcjdokexltwwsfamqpabnuy\n" + 
			"ivjhczdokebltwgsfydqprbnuy\n" + 
			"ivjhcadokexftogsfamqprbnuy\n" + 
			"idjhczdokexltwgsfacqprbnuh\n" + 
			"ivjhgzookexltwgsfamqjrbnuy\n" + 
			"uvjhctdokexltwosfamqprbnuy\n" + 
			"ivrhczdokexltwhzfamqprbnuy\n" + 
			"ivjhczuxkexltwgsfamqprbney\n" + 
			"ivjhczdokemltwgsfadnprbnuy\n" + 
			"ifjhczdokexltwgsfamqprbkuf\n" + 
			"ivjhkzdokltltwgsfamqprbnuy\n" + 
			"ivjuczdhkexltwgsfamqprtnuy\n" + 
			"ivjhjzdxkexltwgsfapqprbnuy\n" + 
			"ivlhczdoxexltwgsfamqprgnuy\n" + 
			"ivjhczdoknxltwgssamqsrbnuy\n" + 
			"ivjhczdokexltwgswadqprbruy\n" + 
			"ivjhczdokexthwgsfampprbnuy\n" + 
			"uvjhczrozexltwgsfamqprbnuy\n" + 
			"ivolczdokexltwgsffmqprbnuy\n" + 
			"ivjhczibkexltwgsfamoprbnuy\n" + 
			"ivjhczdokefltmgsfamqprbouy\n" + 
			"ivjhczdobexltngsfamsprbnuy\n" + 
			"ivjhczdokexltwvsfxqqprbnuy\n" + 
			"dvjhczdokexucwgsfamqprbnuy\n" + 
			"kvjhszkokexltwgsfamqprbnuy\n" + 
			"ivjhczdokexrtegsfamqprbnus\n" + 
			"ivjhctdokexltwglgamqprbnuy\n" + 
			"ivjhczdozexutwgsfamqdrbnuy\n" + 
			"ivjhczqokemltwgsfakqprbnuy\n" + 
			"uvjhczdokexlqwgsfadqprbnuy\n" + 
			"ivjhczdohexltwglffmqprbnuy\n" + 
			"izjhczdokexltwgsfamqprbsqy\n" + 
			"iajhczdokwxltwgjfamqprbnuy\n" + 
			"ivjfczdokexllwgslamqprbnuy\n" + 
			"ivjhczdoyexltwgsfamqdrbnxy\n" + 
			"ivjhczdokekwtwssfamqprbnuy\n" + 
			"ivjhcodokexltwgsfamqirxnuy\n" + 
			"ihjhhzdokexltwgsfamqlrbnuy\n" + 
			"ivjdpzdokexltwfsfamqprbnuy\n" + 
			"ivjhcpdokexltwgsfamqqrbruy\n" + 
			"qvjhcziokexltwgsfamqprbnny\n" + 
			"ivohczdomexltwgsfkmqprbnuy\n" + 
			"ivjhczhokhxlywgsfamqprbnuy\n" + 
			"ivjhczdokexltwgmffmqprbruy\n" + 
			"ivjhczdokqxltwgcfamqprbnyy\n" + 
			"ivjhczdokepltwgsfamcprbnay\n" + 
			"ivjhczdokexltwgseamqpmbnua\n" + 
			"ivjzczdokexltwgszamqplbnuy\n" + 
			"ivjhczpokexltwgvfgmqprbnuy\n" + 
			"idjhczdokexltwgsxamqprbndy\n" + 
			"ivjhczdxkexltwgcgamqprbnuy\n" + 
			"ivjhczdckexatpgsfamqprbnuy\n" + 
			"ivjrczdorexltwgsfamqprbnvy\n" + 
			"ivjoczdokexltwgswamqprbtuy\n" + 
			"iylhczdokexltwgsfamqpxbnuy\n" + 
			"imxhczdokkxltwgsfamqprbnuy\n" + 
			"ivvhczdoktxltwgsfamaprbnuy\n" + 
			"ivyhczdokexltwhsfayqprbnuy\n" + 
			"ivjhcrdokexltegsfamqprbnum\n" + 
			"rvjhezdokexltwgsoamqprbnuy\n" + 
			"ivjzczdokexlbwgsfkmqprbnuy\n" + 
			"ivjhczdokelltwgsyamqprbnoy\n" + 
			"ixjhczdorexltwgsfamqprbuuy\n" + 
			"ivjhczpokexdtwglfamqprbnuy\n" + 
			"ivjhczdokexltwgfgamcprbnuy\n" + 
			"ikjhczdokexltwgsfamqirbnux\n" + 
			"ivjhczdopjxltwgsfamqprbnny\n" + 
			"ivchczdokexltwgniamqprbnuy\n" + 
			"ivjhczdooeqltwgsfamqprbniy\n" + 
			"ivjhcldonexltwgbfamqprbnuy\n" + 
			"ixjhczdokehltwgsfamqprbnuf\n" + 
			"ivjhczdckefltwgsfamqppbnuy\n" + 
			"ivjhczdoqrxltwgsfamqprbnun\n" + 
			"ivjhczdokcxltwgmfarqprbnuy\n" + 
			"ivjhcziorexltqgsfamqprbnuy\n" + 
			"ivjhwzdokexltwgnfamqprbcuy\n" + 
			"ivjhczdoqexltwgsfazqprunuy\n" + 
			"iijhczdokexltwgsyamqprbnug\n" + 
			"ivjhczdokexltwgxfamhprbnry\n" + 
			"ivjhczdakexltwgsfaeqlrbnuy\n" + 
			"ivjhqzdokehltwgsfampprbnuy\n" + 
			"ivjhczdokexltwlsfpmyprbnuy\n" + 
			"ivjhfzdoktxltwgsfamzprbnuy\n" + 
			"ivlhvzdokexltwgsvamqprbnuy\n" + 
			"ivjhczdbkexltwgsaamqprfnuy\n" + 
			"ivahcedokexltigsfamqprbnuy\n" + 
			"cvjhczdokexltwgsfamapibnuy\n" + 
			"ivjhczkokbxltwgsfbmqprbnuy\n" + 
			"pvjuczdnkexltwgsfamqprbnuy\n" + 
			"iyjhczdckexotwgsfamqprbnuy\n" + 
			"ivjhzzdokvxltwgsfamqprbnuo\n" + 
			"ivjhczdobexltwgsxamqprbnry\n" + 
			"ivjhczdokexltwgsfaprprbnub\n" + 
			"ivjhczdokexltwgofarqprbkuy\n" + 
			"ivjhczdokexltwgbfymqprbnhy\n" + 
			"ibjhczdokexltwgsfkmqpvbnuy\n" + 
			"ivjhczdzkexlywgsfacqprbnuy\n" + 
			"hvdhczdokexltwglfamqprbnuy\n" + 
			"ivjhczdokexrtwgsfamqprbsuh\n" + 
			"ivjhczhokexltngsfamqpjbnuy\n" + 
			"ivjhcsjokexltwgsfaeqprbnuy\n" + 
			"ivjmczdokexltmgsfamqpbbnuy\n" + 
			"wvjhczdokexltwgsfamkpkbnuy\n" + 
			"icjhpzdoaexltwgsfamqprbnuy\n" + 
			"ivjmczdhkexltwgsfzmqprbnuy\n" + 
			"ivjhczdokexytwgsfamqprbwug\n" + 
			"ikjhczdjkexljwgsfamqprbnuy\n" + 
			"ivjvcdmokexltwgsfamqprbnuy\n" + 
			"ivjhazdorixltwgsfamqprbnuy\n" + 
			"ivchczdokexltwgsfamzprenuy\n" + 
			"ivjcczdokexlttgsfamqpmbnuy\n" + 
			"ibchgzdokexltwgsfamqprbnuy\n" + 
			"ivjhczdokepltwgsfamqpeenuy\n" + 
			"ivjnwzdokexlrwgsfamqprbnuy\n" + 
			"ivjhczdokexitwgsfadqlrbnuy\n" + 
			"icjhcrdokexltwgsfamqkrbnuy\n" + 
			"ivngczdokexltwgsfamqprbyuy\n" + 
			"ivjhuudokexlvwgsfamqprbnuy\n" + 
			"ivjhczdnkexltwgsfhmqpxbnuy\n" + 
			"itjhczdokexltwvsfamgprbnuy\n" + 
			"ivjhcddokexltwgsfakqprbnny\n" + 
			"ivjhuzdojexltwfsfamqprbnuy\n" + 
			"idjhczdokexltwgsfamqukbnuy\n" + 
			"ivjhczdokexlzigsfamqprbngy\n" + 
			"ivjwczdokexltwgufamqprbnuo\n" + 
			"iijhczdokexltwfsfadqprbnuy\n" + 
			"ivjhczdukexdtwgsfamqpsbnuy\n" + 
			"idjhczdokexllwgssamqprbnuy\n" + 
			"zvjhczdokexrtwgsfamqplbnuy\n" + 
			"ivphczdofexltwgefamqprbnuy\n" + 
			"ivhhczdokexlpwgsjamqprbnuy\n" + 
			"ivjhczdovexltwgsfamqprhnuj\n" + 
			"ivjhczdoklxltwgseamqprlnuy\n" + 
			"ivjhcqdokexltngsfamqprdnuy\n" + 
			"ivjhczdoifxltagsfamqprbnuy\n" + 
			"izjhczdokexltwjsramqprbnuy\n" + 
			"psjhczdokexlgwgsfamqprbnuy\n" + 
			"ivjhcadokexltwgsfsmqwrbnuy\n" + 
			"ivjhczdokexltwgsfawqiibnuy\n" + 
			"ivjhczkokexhtwgsfamqprbnuk\n" + 
			"ivjhcmdukexltwgsfamvprbnuy\n" + 
			"ivjlczdokexltwgsfamquibnuy\n" + 
			"ivjhczdokexntwgyfamqprbniy\n" + 
			"ivjhczdokexltwlsfafqprbnuc\n" + 
			"ivjhczdosexltrtsfamqprbnuy\n" + 
			"ivjhcznokexbtwgsfafqprbnuy\n" + 
			"ivwtczdotexltwgsfamqprbnuy\n" + 
			"ivjhvzdokexltigsoamqprbnuy\n" + 
			"ivjhcmdokexltwasfamqirbnuy\n" + 
			"ivthczdokexltwgsfaydprbnuy\n" + 
			"ivjhwzdskexltwgsfamqprbnus\n" + 
			"icjhczdosuxltwgsfamqprbnuy\n" + 
			"ivjhczdokexltwgstamqbrmnuy\n" + 
			"iejhczuoktxltwgsfamqprbnuy\n" + 
			"ivjhczdokeqltwgskamqprbniy\n" + 
			"ivjhlzdokexltugsfamqprbpuy\n" + 
			"iwjqczdckexltwgsfamqprbnuy\n" + 
			"ivjhwzdokexluwgsfxmqprbnuy\n" + 
			"ivjhczdokexltwgwfwmqprbguy\n" + 
			"gvjhczkokexltwgsfgmqprbnuy\n" + 
			"ivjhczdoyexlhwgsfamqprbnoy\n" + 
			"cvjhczdokexltwgsfomqprinuy\n" + 
			"vvmhczdokexltwgsfamqprbnun\n" + 
			"vvjhczdokexltwgsftmfprbnuy\n" + 
			"ivkhckdokhxltwgsfamqprbnuy\n" + 
			"iyjhczdkkexltjgsfamqprbnuy\n" + 
			"ivlhczdokexltwgsfamqyrbhuy\n" + 
			"tvjhmzdokexltwgsfamqorbnuy\n" + 
			"ivjhczdokexltwvsfamqprbnxi\n" + 
			"ivjhczdowexltwgswamqerbnuy\n" + 
			"wvjiczdomexltwgsfamqprbnuy\n" + 
			"ivjpizdokexltwgvfamqprbnuy\n" + 
			"ivjhuzdokexlzwgspamqprbnuy\n" + 
			"ivjhczdokeyltwgkfamqprdnuy\n" + 
			"jvjhczdokexlnwgsfamqirbnuy\n" + 
			"ivjheidokexltwvsfamqprbnuy\n" + 
			"mvjhczdokexltwgsfamqyrsnuy\n" + 
			"ivjhazdykexltwgsramqprbnuy\n" + 
			"ivjkcodokexltwgsxamqprbnuy\n" + 
			"ikjhczdoktxltwgpfamqprbnuy\n" + 
			"ivjhyzdfkexmtwgsfamqprbnuy\n" + 
			"ivohczdokexltugsfamqprynuy\n" + 
			"ivjkczdqkexltwgshamqprbnuy\n" + 
			"ivjhczdokexltwgskamqynbnuy\n" + 
			"icjhczdokexltwgofamrprbnuy\n" + 
			"ivjhlzdokealtwgsfamqsrbnuy\n" + 
			"ivehczdybexltwgsfamqprbnuy\n" + 
			"ovjhczdokexltwgsfamqirbnuo\n" + 
			"ivjoczdokexltwgsfamqurbnty\n" + 
			"ivjmczdokexltwgsfrmqprnnuy\n" + 
			"ivjhczdowpxltwgbfamqprbnuy\n" + 
			"ivjhczdokexltwfsfamqkrgnuy\n" + 
			"ivjhwzdokexltwgsfavqprbnuq\n" + 
			"jvjhczdokexltwgsiamqprbnny\n" + 
			"ivjhlzdouexltwfsfamqprbnuy\n" + 
			"ivjhczdokexltwgsfamqbrbnlv\n" + 
			"iwjhczdokexltwgsfapqprbnqy\n" + 
			"idjhczdokexltwgsaamqrrbnuy\n" + 
			"ivjhjzdopepltwgsfamqprbnuy\n" + 
			"ivjmczdokejltwgsfamqpbbnuy\n" + 
			"ivjhczdokexltwgsuamdprvnuy\n" + 
			"injhczdokexltwgefamqurbnuy\n" + 
			"iujhczdokexltwgsaamqjrbnuy\n" + 
			"ivjhczdokexltwgvfaaqprbnly\n" + 
			"ivehczdokexltwgsfamqppbnui\n" + 
			"ivxhczdodexltwgsfamqplbnuy\n" + 
			"ivjhczfokexltwgsfamqpwbauy\n" + 
			"ivjhcztwkexhtwgsfamqprbnuy\n" + 
			"ivjeczdokexltygsfmmqprbnuy\n" + 
			"ivjhchdokexltwgsmameprbnuy\n" + 
			"ivkhczdoklxltwggfamqprbnuy\n" + 
			"ivjhczdzkexltwhsfamqprjnuy\n" + 
			"ivjhcedokeultngsfamqprbnuy\n" + 
			"ivjhczdokexvtwgseabqprbnuy\n" + 
			"ivjhczdooexltlgsfamqpibnuy\n" + 
			"ivjgczvosexltwgsfamqprbnuy\n" + 
			"ivlhczwokexltwgsfamqmrbnuy\n" + 
			"lvjhczdokexutwgsfamrprbnuy\n" + 
			"ivahczdokexpdwgsfamqprbnuy\n" + 
			"ivjhcznokexltwhsfamqpnbnuy\n" + 
			"ivjhczdpkyxltwgbfamqprbnuy\n" + 
			"ivjhnzdokexltwgsftmqprinuy\n" + 
			"ivihczdokexltnhsfamqprbnuy\n" + 
			"ivjhcbdokevltwgsfamqprbauy\n" + 
			"hgjoczdokexltwgsfamqprbnuy\n" + 
			"dvjhczdckexltwgsfamqpybnuy\n" + 
			"ivjhcadokesltwgsfsmqwrbnuy\n" + 
			"ivjhwzdokexlttgsfamqprbney\n" + 
			"ivjhcidokexltwgofamqfrbnuy\n" + 
			"ivokwzdokexltwgsfamqprbnuy\n" + 
			"ivjiczdokexltwgsfaqqarbnuy\n" + 
			"ivjhczdokexqtwfsfamgprbnuy\n" + 
			"ivjhczdokealtwgsfamqerbnqy\n" + 
			"ivjhczdskexltwgsfamqprznuu\n" + 
			"ivjhwzdokexltwjsfdmqprbnuy\n" + 
			"ivjhczaokexlzwgsfamqprbnus\n" + 
			"ivjhczdokexltwosfamqnrbnux\n" + 
			"ivjhczdokexlqwgsfamwprcnuy\n" + 
			"ivjhczdqkexltwgswamqpcbnuy\n" + 
			"ijjhczdokexnttgsfamqprbnuy\n" + 
			"ivjhcedckexltwgsfamqprbnpy\n" + 
			"ivjhczdokeyltwgsfamqshbnuy\n" + 
			"ivjhczdokexltsgsfamqpmznuy\n" + 
			"ivjlczdtkeiltwgsfamqprbnuy\n" + 
			"ivjhczdokexltwgsfkmtprbnby\n" + 
			"ivjhnzdozexltwgsfamqprbnuc\n" + 
			"xqjxczdokexltwgsfamqprbnuy\n" + 
			"ivjhczdokeyltwgsfamqnrbnuw\n" + 
			"ivjwczgokexltwgsfamvprbnuy\n";
}
