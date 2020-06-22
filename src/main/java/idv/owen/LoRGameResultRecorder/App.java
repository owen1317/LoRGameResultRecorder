package idv.owen.LoRGameResultRecorder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import no.stelar7.api.r4j.impl.lor.LoRClientAPI;
import no.stelar7.api.r4j.pojo.lor.offline.card.LoRDeck;
import no.stelar7.api.r4j.pojo.lor.offline.game.LoRGameResult;

/**
 * Hello world!
 *
 */
public class App 
{
public static void main(String[] args) {
		
		//Create a file to write result everytime this program start.
		File file = new File(DateUtil.convertLong2Str(System.currentTimeMillis(), "yyyy-MM-dd") +"__" +System.currentTimeMillis() + " log");
		BufferedWriter fw = null;
		FileOutputStream fis = null;
		try {
			fis = new FileOutputStream(file);
			System.out.println("Press any key to proceed!");
			System.in.read();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		String[] recoredGameIdList = {};
		
		while (true){
			LoRDeck deck = LoRClientAPI.getActiveDeck();
			LoRGameResult result = LoRClientAPI.getLastGameResult();
			
			if(Arrays.stream(recoredGameIdList).anyMatch(result.getGameId()::equals) || result.getGameId().equals("-1")) {
				continue;
			}
			
			try {
				fw = new BufferedWriter(new OutputStreamWriter(fis, "UTF-8")); // 指點編碼格式，以免讀取時中文字符異常
				fw.append("Game " + result.getGameId() );
				fw.newLine();
				fw.append("Result: " + ((result.isLocalPlayerWon())?"Win":"Loss"));
				fw.newLine();
				fw.append("Deck Code: " + deck.getDeckCode());
				recoredGameIdList = append(recoredGameIdList, result.getGameId());
				fw.newLine();fw.newLine();fw.newLine();
				fw.flush();
				
				Thread.sleep(5000);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
//				if (fw != null) {
//				  try {
//				    fw.close();
//				  } catch (IOException e) {
//				    e.printStackTrace();
//				  }
//				}
			}
			
        }
		
	}
	
	public void testActiveDeck(){
        LoRDeck deck = LoRClientAPI.getActiveDeck();
        System.out.println();
    }
	
	 public void testGameResult(){
	    LoRGameResult result = LoRClientAPI.getLastGameResult();
	    System.out.println();
	}
	 
	 static <T> T[] append(T[] arr, T element) {
		    final int N = arr.length;
		    arr = Arrays.copyOf(arr, N + 1);
		    arr[N] = element;
		    return arr;
		}
}
