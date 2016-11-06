package w.p.j.util;

import org.apdplat.word.analysis.SimpleTextSimilarity;
import org.apdplat.word.analysis.TextSimilarity;

/**
 * Name：CompareText
 * Time：2016/10/30 20:35
 * author：WPJ587
 * description：比较文本信息
 **/

public class CompareText {
    public static void main(String[] args) {
        String text1="深入贯彻三个代表,毛泽东思想邓小平理论";
        String text2="深入贯彻毛泽东思想邓小平理论三个代表的重要思想";
//       TextSimilarity textSimilarity = new SimpleTextSimilarity();
        TextSimilarity textSimilarity = new SimpleTextSimilarity();

        double score1pk1 = textSimilarity.similarScore(text1, text1);
        double score1pk2 = textSimilarity.similarScore(text1, text2);
        System.out.println(score1pk1);
        System.out.println(score1pk2);
    }
}
