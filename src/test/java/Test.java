import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author lyldelove
 * @title Test
 * @url
 * @tag
 * @date 2020/5/27 7:20
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(new Md5Hash("a" + "1" + "b").toHex());
    }

}
