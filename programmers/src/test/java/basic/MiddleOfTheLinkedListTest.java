package basic;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MiddleOfTheLinkedListTest {
    @Test
    void solution() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node5.setNext(node4);
        node3.setNext(node4);
        node2.setNext(node3);
        head.setNext(node2);

        ListNode middle = middleOfTheLinkedList(head);
        assertThat(middle.getVal()).isEqualTo(3);
    }

    /**
     *
     * 워커 러너 테크닉
     * 워커 1번
     * 러너 2번
     * 러너가 끝나면 워커 중간
     * */
    private ListNode middleOfTheLinkedList(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;
        while (runner != null) {
            runner = runner.next;
            if (runner != null) {
                walker = walker.next;
                runner = runner.next;
            }
        }

        return walker;
    }
}
