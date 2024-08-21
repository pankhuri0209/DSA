package roblox;

import java.util.ArrayList;
import java.util.List;

public class browserHistory {

    private List<String> history;
    private int currentIndeix;

    public browserHistory(String homepage)
    {
        history = new ArrayList<>();
        history.add(homepage);
        currentIndeix=0;
    }
    public void visit(String url)
    {
        history = history.subList(0,currentIndeix+1);
        history.add(url);
        currentIndeix++;
    }

    public String back(int steps)
    {
        currentIndeix = Math.max(0, currentIndeix-steps);
        return history.get(currentIndeix);
    }
    public String forward(int steps)
    {
        System.out.println("");
        currentIndeix=Math.min(history.size()-1, currentIndeix+steps);
        return  history.get(currentIndeix);
    }

}
