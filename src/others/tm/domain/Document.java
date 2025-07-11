package others.tm.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import others.tm.util.WordSplit;

public class Document implements Comparable<Document> {

    private String content; //内容
    private List<String> words; //单词

    private String project, label; //项目,标记

    private Map<String, Double> tf;

    double scoreForRank;

    public int compareTo(Document doc) {
        if (this.scoreForRank < doc.scoreForRank)
            return -1;
        else if (this.scoreForRank > doc.scoreForRank)
            return 1;
        else return 0;
    }

    public Document(String content) {
        this.content = content;
        this.words = WordSplit.split(content);

        //build term frequency
        this.tf = new HashMap<>();
        for (String word : this.words) {
            if (tf.containsKey(word)) tf.put(word, tf.get(word) + 1);
            else tf.put(word, 1.0);
        }
        //normalize tf
        for (Map.Entry<String, Double> entry : this.tf.entrySet()) {
            entry.setValue(entry.getValue() * 1.0 / this.words.size());
        }
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Map<String, Double> getTf() {
        return tf;
    }

    public void setTf(Map<String, Double> tf) {
        this.tf = tf;
    }

    public double getScoreForRank() {
        return scoreForRank;
    }

    public void setScoreForRank(double scoreForRank) {
        this.scoreForRank = scoreForRank;
    }
}
