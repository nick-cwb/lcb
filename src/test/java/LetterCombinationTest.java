import indi.nick.lcb.service.LetterCombinationService;
import org.junit.Assert;
import org.junit.Test;

public class LetterCombinationTest {

    LetterCombinationService service = new LetterCombinationService();

    @Test
    public void case1(){
        int[] array = new int[]{2,3};
        String[] strArr = new String[]{"AD","AE","AF","BD","BE","BF","CD","CE","CF"};
        Assert.assertArrayEquals(service.combinate(array),strArr);
    }


    @Test
    public void case2(){
        int[] array = new int[]{9};
        String[] strArr = new String[]{"W","X","Y","Z"};
        Assert.assertArrayEquals(service.combinate(array),strArr);
    }

    @Test
    public void case3(){
        int[] array = new int[]{23};
        String[] strArr = new String[]{"AD","AE","AF","BD","BE","BF","CD","CE","CF"};
        Assert.assertArrayEquals(service.combinate(array),strArr);
    }

    @Test
    public void case4(){
        int[] array = new int[]{2,3,4};
        String[] strArr = new String[]{"ADG","ADH","ADI","AEG","AEH","AEI","AFG","AFH","AFI",
                                        "BDG","BDH","BDI","BEG","BEH","BEI","BFG","BFH","BFI",
                                        "CDG","CDH","CDI","CEG","CEH","CEI","CFG","CFH","CFI"};
        Assert.assertArrayEquals(service.combinate(array),strArr);
    }

    @Test
    public void case5(){
        int[] array = new int[]{23,4};
        String[] strArr = new String[]{"ADG","ADH","ADI","AEG","AEH","AEI","AFG","AFH","AFI",
                "BDG","BDH","BDI","BEG","BEH","BEI","BFG","BFH","BFI",
                "CDG","CDH","CDI","CEG","CEH","CEI","CFG","CFH","CFI"};
        Assert.assertArrayEquals(service.combinate(array),strArr);
    }


}
