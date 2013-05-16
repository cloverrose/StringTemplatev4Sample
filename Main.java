import org.stringtemplate.v4.*;

public class Main{

    public static void main(String[] args){

        STGroup group = new STGroupDir("templates");
        ST st = group.getInstanceOf("decl");
        st.add("type", "int");
        st.add("name", "x");
        st.add("value", 0);
        String result = st.render(); // yields "int x = 0;"
        System.out.println(result);

        ST st2 = group.getInstanceOf("propDef");
        st2.add("type", "serv");
        st2.add("name", "x");
        st2.add("indexs", "[{0}][{1}]");
        st2.add("formatargs", "i0, i1");
        st2.add("head", "{i0: {i1: ");
        st2.add("tail", " for i1 in range(2, 20)} for i0 in range(1, 10)}");
        String result2 = st2.render(); // yields "int x = 0;"
        System.out.println(result2);
    }
}
