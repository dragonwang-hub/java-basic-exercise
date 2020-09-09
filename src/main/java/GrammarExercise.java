
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GrammarExercise {
    /*
        public static void main(String[] args) {
            //需要从命令行读入
            String firstWordList = "apple,juice,mother,people,beautiful,apple,dog";
            String secondWordList = "cat,baby,smile,good,apple,beautiful,Dog,nice";

            List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
            //按要求输出到命令行

        }
    */
    public List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
        String[] firstStr = firstWordList.toUpperCase().split(",");
        String[] secndStr = secondWordList.toUpperCase().split(",");
        // 正则校验字符串格式
        regMatch(firstStr);
        regMatch(secndStr);
        
        List<String> firstList = Arrays.stream(firstStr).distinct().collect(Collectors.toList());
        List<String> secndList = Arrays.stream(secndStr).distinct().collect(Collectors.toList());
        List<String> commonWord = secndList.stream().filter(firstList::contains).sorted().map(str -> str.replace("", " ").trim()).collect(Collectors.toList());
        return commonWord;
    }

    private void regMatch(String[] args) {
        String regExp = "[A-Z]+";
        for (String arg : args) {
            if (!Pattern.matches(regExp, arg)) {
                throw new RuntimeException("input no");
            }
        }
    }
}
