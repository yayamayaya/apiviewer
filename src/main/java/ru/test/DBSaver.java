package ru.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.test.demonstrator.CFG;
import ru.test.demonstrator.nodes.*;

public class DBSaver {
    public static CFG buildForDemo() {
        String instr1[] = {"env!BB:", "instr'pmove args to &args", "instr'NOP", "instr'pmove 1 to &x", "instr'x = deref &x"};
        String instr3[] = {"env!BB:", "assume x==1",    "instr'RET branch"};
        String instr4[] = {
                "env!BB:",
                "assume x != 1",
                "instr'System.out = deref System.out(#$-666)",
                "instr\'method_call  #1: PrintStream.print.69dcfaad(System.out,\"hi\")",
                "instr'RET branch",
        };
        String instr6[] = {"env!inst'annotate"};

        CfgNode nodes[] = {
                new EntryNode(0, 2),
                new BlockNode(1, 3, 1, instr1),
                new SplitNode(2, 2, new Integer[] {4, 5}),
                new BlockNode(3, 6, 3, instr3),
                new BlockNode(4, 6, 3, instr4),
                new JoinNode(5, new Integer[] {4, 5}, 7),
                new BlockNode(6, 8, 6, instr6),
                new EndNode(7, 7),
        };

        return new CFG(nodes);
    }

    public static void main(String[] args) {
        CFG cfg = buildForDemo();
        System.out.println("cfg = " + cfg);

        Configuration configuration = new Configuration();
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(cfg);

        transaction.commit();
    }
}