package Domain;

public class Epic extends Task {
    protected String[] subtasks = new String[0];

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    @Override
    public boolean matches(String query) {
        int count = 0;
        for (int i = 0; i < subtasks.length; i++) {
            if (subtasks[i].contains(query)){
                count++;
            }
                if (count >= 1) {
                    return true;
                }
        }
        return false;
    }

    public String[] getSubtasks() {
        return subtasks;
    }


}
