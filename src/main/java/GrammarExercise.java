import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        String[] firstStrArray = firstWordList.toUpperCase().split(",");
        String[] secondStrArray = secondWordList.toUpperCase().split(",");

        List<String> firList = Stream.of(firstStrArray).distinct().collect(Collectors.toList());
        List<String> secList = Stream.of(secondStrArray).distinct().collect(Collectors.toList());
        match(firList, secList);
        List<String> result = firList.stream().filter(secList::contains).sorted().collect(Collectors.toList());
        List<String> re = new ArrayList<>();
        result.forEach(str->{
            re.add(str.replace(""," ").trim());
        });
        return re;

    }
    private void match(List<String> firList, List<String> secList) {
        reg(firList);
        reg(secList);
    }
    private void reg(List<String> list) {
        String reg = "[A-Z]+";
        for (int i = 0; i < list.size(); i++) {
            if (!Pattern.matches(reg, list.get(i))) {
                throw new RuntimeException("input no");
            }
        }
    }
}
