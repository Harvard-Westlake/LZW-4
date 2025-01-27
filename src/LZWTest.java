import java.io.IOException;
import java.util.List;

public class LZWTest {

	public static void main(String[] args) throws IOException {
		
		Lzw lzw = new Lzw();
		String input = "aababab";
		List<Integer> results = lzw.compress(input);
		System.out.println(results);
		String output = lzw.decompress(results);
		System.out.println("input and output should be equal! " + input.equals(output));
		
		FileUtility fileUtility = new FileUtility();
		String fileContent = fileUtility.readTextFile("/Users/lanalim/eclipse-workspace/LZW/src/lzw-file1.txt");
		System.out.println(" file content: " + fileContent);
		
		byte[] resultInBytes = fileUtility.convertToByteArray(results);
		
		System.out.println(resultInBytes);
		
		
		fileUtility.writeBytesToFile(resultInBytes, "/Users/lanalim/eclipse-workspace/LZW/src/lzw-file1-output.lzw");

		// Testing Decompression
		String compressedContent = fileUtility.readTextFile("/Users/lanalim/eclipse-workspace/LZW/src/lzw-file1-output.lzw");

		List<Integer> compressedDataFromFile = fileUtility.convertToIntegerList(compressedContent);
		
		System.out.println("compress data file: " + compressedDataFromFile);
		
		String  decompressContent = lzw.decompress(compressedDataFromFile);
		
		System.out.println(decompressContent);
		
		
		// testing with a bigger file
		String fileBigContent = fileUtility.readTextFile("/Users/lanalim/eclipse-workspace/LZW/src/lzw-file3.txt");
		List<Integer> compressedBigContent = lzw.compress(fileBigContent);
		byte[] bigContentResultInBytes = fileUtility.convertToByteArray(compressedBigContent);
		
		fileUtility.writeBytesToFile(bigContentResultInBytes, "/Users/lanalim/eclipse-workspace/LZW/src/lzw-file3-output.lzw");



	}
				
}


