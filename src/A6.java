/*
 * user name D0280184
 */
import java.util.ArrayList;
public class A6 {
	public static void main(String[] args) {
		Component test = new TestPaper();
		if (test instanceof TestPaper) {
			test.addQuestion(new Question("1 + 1 = ?"));
		}
		test.doQuestion();
	}
}
abstract class Component {
	abstract void doQuestion();
	abstract void addQuestion(Question question);
}

class Question extends Component {
	String description;
	public Question(String desc) {
		this.description = desc;
	}
	public void print() {
		System.out.println(this.description);
	}
	@Override
	void doQuestion() {
		print();
	}
	@Override
	void addQuestion(Question question) {
	}
}

class TestPaper extends Component {
	ArrayList<Component> list;
	public TestPaper() {
		list = new ArrayList<>();
	}
	public void addQuestion(Question q) {
		list.add(q);
	}
	@Override
	void doQuestion() {
		list.forEach(Component::doQuestion);
	}
}