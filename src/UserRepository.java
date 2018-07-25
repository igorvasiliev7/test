public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public String[] getUserNames() {

        String[] names = new String[users.length];
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) names[i] = users[i].getName();
        }
        return names;
    }

    public long[] getUserIds() {
        int j = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) j++;
        }

        long[] ids = new long[j];
        j = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                ids[i] = users[i].getId();
                j++;
            }

        }
        return ids;
    }

    public String getUserNameById(long id) {
        String name = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) ;
            else if (users[i].getId() == id) {
                name = users[i].getName();
                return name;
            }

        }

        return null;
    }

    public User getUserByName(String name) {
        //User user = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) if (users[i].getName().equals(name)) return users[i];
        }
        return null;
    }

    public User findById(long id) {
        //User user = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) if (users[i].getId() == id) return users[i];
        }

        return null;
    }

    public User getUserBySessionId(String sessionid) {
        //User user = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) if (users[i].getSessionId().equals(sessionid)) return users[i];
        }
        return null;
    }

    public User save(User user) {

        if (this.findById(user.getId()) != null) return null;

        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                return users[i];
            }
        }


        return null;
    }

    public User update(User user) {

        if (this.findById(user.getId()) == null) return null;

        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) if (users[i].getId() == user.getId()) {
                users[i] = user;
                return users[i];
            }
        }

        return null;
    }

    public void delete(long id) {
        if (this.findById(id) != null)
            for (int i = 0; i < users.length; i++) {
                if (users[i] != null) if (users[i].getId() == id) {
                    users[i] = null;

                }
            }
    }

}