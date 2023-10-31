package sample03;

// Bean을 설정하고 인스턴스화한 다음 해당 Bean을 사용하는 예제
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Ex01 {
	public static void main(String[] args) {
		
		/** FileSystemXmlApplicationContext를 사용하여
		 *  Bean 정의를 포함하는 XML 설정 파일인 "beans01.xml"을 로드 */
//		BeanFactory bf = new XmlBeanFactory(new FileSystemResource("beans01.xml"));
		ApplicationContext bf = new FileSystemXmlApplicationContext("beans01.xml");

		/** ApplicationContext에서
		 *  "mb"라는 이름을 가진 Bean을 가져와 mb 변수에 할당 */
		// MessageBean mb = bf.getBean("mb", MessageBean.class);
		MessageBean mb = (MessageBean) bf.getBean("mb");
		// MessageBean mb = bf.getBean(MessageBean.class);
		// MessageBean mb = (MessageBean)bf.getBean("a");
		mb.sayHello("Spring");
	}
}