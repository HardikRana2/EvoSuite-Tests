package io.diffblue.corebanking.transaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import io.diffblue.corebanking.account.Account;
import io.diffblue.corebanking.client.Client;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Ignore;

import org.junit.Rule;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BankTransactionTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * Method under test: {@link BankTransaction#BankTransaction(long, Date, Account, Account)}
     */
    @Test
    public void testConstructor() {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        Account sourceAcc = new Account(1234567890L, new Client("Dr Jane Doe"), 10L);

        BankTransaction actualBankTransaction = new BankTransaction(10L, fromResult, sourceAcc,
                new Account(1234567890L, new Client("Dr Jane Doe"), 10L));

        assertEquals("1234567890", actualBankTransaction.getSource());
        assertEquals(Transaction.TransactionState.NOT_EXECUTED_YET, actualBankTransaction.getTransactionState());
        assertSame(fromResult, actualBankTransaction.getTransactionDate());
        assertEquals(10L, actualBankTransaction.getTransactionAmount());
        assertEquals("1234567890", actualBankTransaction.getTarget());
    }

    /**
     * Method under test: {@link BankTransaction#getSource()}
     */
    @Test
    public void testGetSource() {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date date = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        Account sourceAcc = new Account(1234567890L, new Client("Dr Jane Doe"), 10L);

        assertEquals("1234567890",
                (new BankTransaction(10L, date, sourceAcc, new Account(1234567890L, new Client("Dr Jane Doe"), 10L)))
                        .getSource());
    }

    /**
     * Method under test: {@link BankTransaction#getSource()}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testGetSource2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at io.diffblue.corebanking.transaction.BankTransaction.getSource(BankTransaction.java:32)
        //   In order to prevent getSource()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getSource().
        //   See https://diff.blue/R013 to resolve this issue.

        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date date = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        (new BankTransaction(10L, date, null, new Account(1234567890L, new Client("Dr Jane Doe"), 10L))).getSource();
    }

    /**
     * Method under test: {@link BankTransaction#getTarget()}
     */
    @Test
    public void testGetTarget() {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date date = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        Account sourceAcc = new Account(1234567890L, new Client("Dr Jane Doe"), 10L);

        assertEquals("1234567890",
                (new BankTransaction(10L, date, sourceAcc, new Account(1234567890L, new Client("Dr Jane Doe"), 10L)))
                        .getTarget());
    }

    /**
     * Method under test: {@link BankTransaction#getTarget()}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testGetTarget2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at io.diffblue.corebanking.transaction.BankTransaction.getTarget(BankTransaction.java:41)
        //   In order to prevent getTarget()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getTarget().
        //   See https://diff.blue/R013 to resolve this issue.

        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date date = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        (new BankTransaction(10L, date, new Account(1234567890L, new Client("Dr Jane Doe"), 10L), null)).getTarget();
    }

    /**
     * Method under test: {@link BankTransaction#executeTransaction()}
     */
    @Test
    public void testExecuteTransaction() throws TransactionException {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date date = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        Account sourceAcc = new Account(1234567890L, new Client("Dr Jane Doe"), 10L);

        BankTransaction bankTransaction = new BankTransaction(10L, date, sourceAcc,
                new Account(1234567890L, new Client("Dr Jane Doe"), 10L));
        bankTransaction.executeTransaction();
        assertEquals(Transaction.TransactionState.EXECUTED, bankTransaction.getTransactionState());
    }

    /**
     * Method under test: {@link BankTransaction#executeTransaction()}
     */
    @Test
    public void testExecuteTransaction2() throws TransactionException {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date date = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        Account sourceAcc = new Account(1234567890L, new Client("Dr Jane Doe"), 10L);

        thrown.expect(TransactionException.class);
        (new BankTransaction(Long.MAX_VALUE, date, sourceAcc, new Account(1234567890L, new Client("Dr Jane Doe"), 10L)))
                .executeTransaction();
    }

    /**
     * Method under test: {@link BankTransaction#executeTransaction()}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testExecuteTransaction3() throws TransactionException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at io.diffblue.corebanking.transaction.BankTransaction.executeTransaction(BankTransaction.java:65)
        //   In order to prevent executeTransaction()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   executeTransaction().
        //   See https://diff.blue/R013 to resolve this issue.

        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date date = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        (new BankTransaction(10L, date, null, new Account(1234567890L, new Client("Dr Jane Doe"), 10L)))
                .executeTransaction();
    }

    /**
     * Method under test: {@link BankTransaction#executeTransaction()}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testExecuteTransaction4() throws TransactionException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at io.diffblue.corebanking.transaction.BankTransaction.executeTransaction(BankTransaction.java:64)
        //   In order to prevent executeTransaction()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   executeTransaction().
        //   See https://diff.blue/R013 to resolve this issue.

        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date date = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        (new BankTransaction(10L, date, new Account(1234567890L, new Client("Dr Jane Doe"), 10L), null))
                .executeTransaction();
    }
}

