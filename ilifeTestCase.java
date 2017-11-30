package ilife;

import org.testng.annotations.Test;
import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class ilifeTestCase {

	public AndroidDriver<WebElement> driver;
	private boolean isInstall = false;
	
	@BeforeSuite
	public void setUp() throws  Exception{
		/***
		 * ��ʼ��
		 */
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");  //����ƽ̨
		capabilities.setCapability("platformVersion", "4.4.2");  //�汾
		capabilities.setCapability("deviceName", "7N2QXX144T017459");  //�豸����
		capabilities.setCapability("automationName", "Appium");  //automationName
//		capabilities.setCapability("noRest", true);  //����Ҫ�����ٴΰ�װapp
		capabilities.setCapability("noSign", true);  //��װʱ����apk������ǩ�������ú��б�Ҫ�������е�apk����ǩ��֮���޷�����ʹ��
		capabilities.setCapability("unicodeKeyboard", true);  //������������
		capabilities.setCapability("resetKeyboard", true);  //���ؼ���
		
		//����APP
		capabilities.setCapability("appPackage", "cn.sccl.ilife.android");
		capabilities.setCapability("appActivity", "cn.sccl.ilife.android.uhealth.UhealthWelcomeActivity");
		
		//����appium
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		Thread.sleep(5000);
		
		/***
		 * �ж��豸�Ƿ��Ѿ���װAPP
		 */
		if(isInstall) {
			//set up appium����apk·��
			File classpathRoot = new File(System.getProperty("usr.dir"));
			File appDir = new File(classpathRoot, "apps");
			File app = new File(appDir, "app-debug20170731(testplatform).apk");
			
			capabilities.setCapability("app", app.getAbsolutePath());  //����apk·��
		}
	}
	
	@Test
	/***
	 * ��¼
	 * @throws Exception
	 */
	public void a_ilifeLogin() throws Exception{
//		driver.findElementById("cn.sccl.ilife.android:id/uhealth_welcome_skip").click();  //��������ҳֱ�ӵ���¼����
		/***
		 * ��������ҳ����¼����
		 */
		int width = driver.manage().window().getSize().width;  //��ȡ��Ļ�Ŀ��
		int height = driver.manage().window().getSize().height;  //��ȡ��Ļ�ĸ߶�
		driver.swipe(width*7/8, height/2, width/8, height/2, 1000);  //ͨ������ı仯ʵ����Ļ����
		Thread.sleep(1000);
		driver.swipe(width*7/8, height/2, width/8, height/2, 1000);  //ʹ�ü���swipe�ͱ�ʾ��������
		Thread.sleep(1000);
		/***
		 * �û����������¼
		 */
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_welcome_bt").click();
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_login_phone_et").sendKeys("17761260775");
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_login_pw_et").sendKeys("aaaaaa");
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_login_btn").click();
//		Thread.sleep(3000);
//		driver.findElementById("android:id/button2").click();
		/***
		 * QQ��¼
		 */
//		driver.findElementById("cn.sccl.ilife.android:id/uhealth_welcome_bt").click();
//		driver.findElementById("cn.sccl.ilife.android:id/uhealth_login_qq").click();
//		Thread.sleep(5000);
//		driver.findElementByName("��¼").click();
//		Thread.sleep(5000);
//		driver.findElementById("android:id/button2").click();

		/***
		 *���ܣ��ȴ�������ֳ���ָ��Ԫ�غ��ִ�к���Ĳ���
		 *WebDriverWait(driver, 10) ---10 ��ʾ��ʱʱ��Ϊ10s���˴���λ���룩
		 */
		WebDriverWait wait = new WebDriverWait(driver, 10); //���ó�ʱʱ��
		WebElement e = wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.name("ȷ��������?")); //ָ�����ֵ�Ԫ��
			}
		});
		
		driver.findElementByName("ȡ��").click();
	}
	
	@Test
	/***
	 * �޸ĸ�����Ϣ
	 * @throws Exception
	 */
	public void z_EditInformation() throws Exception{
		driver.findElementByName("�ҵ�").click();
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_me_info_rl").click();
//		driver.findElementById("cn.sccl.ilife.android:id/uhealth_me_info_rl").click();
//		Thread.sleep(1000);
		
		//�޸�ͷ��
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_center_info_head_iv").click();
		driver.findElementByName("�����ѡ��ͼƬ").click();
		driver.findElementById("com.android.documentsui:id/icon_thumb").click();
//		driver.findElementByName("����").click();
//		Thread.sleep(2000);
//		driver.findElementById("com.huawei.camera:id/shutter_button").click();
//		Thread.sleep(2000);
//		driver.findElementById("com.huawei.camera:id/btn_done").click();
		//ȡ��ͷ���޸�
//		driver.findElementByName("ȡ��").click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement e = wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.name("����"));
			}
		});
		
		//�޸�����
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_personal_center_info_name").click();
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_personal_center_de_iv").click();
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_personal_center_old_info").sendKeys("Jerry");
		driver.findElementByName("����").click();
		WebElement f = wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.name("����"));
			}
		});
		
		//�޸��Ա�
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_personal_center_info_xb").click();
//		driver.findElementByName("��").click();
		driver.findElementByName("Ů").click();
		driver.findElementByName("����").click();
		WebElement g = wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.name("����"));
			}
		});
		
		//�޸ĵ�ַ
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_personal_center_info_address").click();
		
		/***
		 *�ֲ㶨λԪ�أ�
		 *1.�Ȼ�ȡ��Ҫ��λԪ�صĿؼ�
		 *2.ͨ���ؼ�ȥ��λԪ��
		 */
		 
//		MobileElement shengf_1 = (MobileElement) driver.findElementByAndroidUIAutomator("resourceId(\"cn.sccl.ilife.android:id/uhealth_lv_city\")");  //��ȡ��Ҫ��λԪ�صĿؼ�
//		MobileElement shengf_2 = (MobileElement) ((FindsByAndroidUIAutomator<WebElement>) shengf_1).findElementByAndroidUIAutomator("text(\"�ӱ�ʡ\")");  //ͨ���ؼ�ȥ��λԪ��
//		shengf_2.click();
//		MobileElement city_1 = (MobileElement) driver.findElementByAndroidUIAutomator("resourceId(\"cn.sccl.ilife.android:id/uhealth_lv_city\")");
//		MobileElement city_2 = (MobileElement) ((FindsByAndroidUIAutomator<WebElement>) city_1).findElementByAndroidUIAutomator("text(\"ʯ��ׯ��\")");
//		city_2.click();
        /***
		 *��һ�ּ򵥵�ʵ��д����ԭ����һ��
		 */
		MobileElement city = (MobileElement) driver.findElementById("cn.sccl.ilife.android:id/uhealth_lv_city");
		city.findElementByName("�ӱ�ʡ").click();
		city.findElementByName("ʯ��ׯ��").click();
		driver.findElementByName("����").click();
		
		WebElement s = wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.name("����"));
			}
		});
		
		//�޸�����   bounds---[220,480][500,786]
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_personal_center_info_nl").click();
		/***
		 * ͨ�������ı仯��ʵ���ڿؼ��ڻ���
		 * ȱ�ݸ÷����������ձ��ԣ�ӦΪ�ֻ���Ļ�Ĵ�С������ͬ����Ҫ���¼��������
		 */
//		Thread.sleep(1000);
//		driver.swipe(360, 780, 360, 450, 1000);
		
		/***
		 * �������������ڲ�ͬ��Ļ������Ҫ������Ļ��С��ͬ���¼�������
		 * 1.��ȡ�ؼ�����ʼ����x��y
		 * 2.��ȡ�ؼ��Ŀ�ȡ��߶�
		 * 3.����ؼ����м������
		 * 4.ʹ��swipe�����ٿؼ��ڻ���
		 */
		WebElement ageSelectDialog = driver.findElement(By.id("cn.sccl.ilife.android:id/list_select_dialog_wv"));
		//����ؼ��м�������x����
		int xStartPoint = ageSelectDialog.getLocation().getX();  //x����ʼ����
		int xEndPoint = xStartPoint + ageSelectDialog.getSize().width;  //x�Ľ������� ,ageDialog.getSize().width ��ȡ�ؼ��Ŀ��
		int x = (xStartPoint+xEndPoint)/2;  //�ؼ��м�������x����
		
		//����ؼ��м�������y����
		int yStartPoint = ageSelectDialog.getLocation().getY();  //y����ʼ����
		int yEndPoint = yStartPoint + ageSelectDialog.getSize().height;  //y�Ľ������� ,ageDialog.getSize().height ��ȡ�ؼ��ĸ߶�
		int y = (yStartPoint+yEndPoint)/2;  //�ؼ��м�������y����
		
		driver.swipe(x, y*7/8, x, y/2, 1000);
		
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_select_ok").click();
//		driver.findElementByName("����").click();
//		driver.findElementById("cn.sccl.ilife.android:id/uhealth_select_cancel").click();
//		driver.findElementByName("ȡ��").click();
		WebElement h = wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.name("����"));
			}
		});
		
		//�޸����
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_personal_center_info_sg").click();
		int xsgStartPoint = ageSelectDialog.getLocation().getX();  //�˴�ʹ��ageSelectDialog������Ϊѡ������������ͬ������ͬ��
		int xsgEndPoint = xsgStartPoint + ageSelectDialog.getSize().width;
		int xsg = (xsgStartPoint+xsgEndPoint)/2;
		
		int ysgStartPoint = ageSelectDialog.getLocation().getY();
		int ysgEndPoint = ysgStartPoint + ageSelectDialog.getSize().getHeight();
		int ysg = (ysgStartPoint+ysgEndPoint)/2;
		
		driver.swipe(xsg, ysg*7/8, xsg, ysg/2, 1000);
		
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_select_ok").click();
//		driver.findElementByName("����").click();
//		driver.findElementById("cn.sccl.ilife.android:id/uhealth_select_cancel").click();
//		driver.findElementByName("ȡ��").click();
		WebElement i = wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.name("����"));
			}
		});
		
		//�޸�����
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_personal_center_info_weight").click();
		int xtzStartPoint = ageSelectDialog.getLocation().getX();
		int xtzEndPoint = xtzStartPoint + ageSelectDialog.getSize().getWidth();
		int xtz = (xtzStartPoint+xtzEndPoint)/2;
		
		int ytzStartPoint = ageSelectDialog.getLocation().getY();
		int ytzEndPoint = ytzStartPoint + ageSelectDialog.getSize().getHeight();
		int ytz = (ytzStartPoint+ytzEndPoint)/2;
		
		driver.swipe(xtz, ytz*7/8, xtz, ytz/2, 1000);
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_select_ok").click();
//		driver.findElementByName("����").click();
//		driver.findElementById("cn.sccl.ilife.android:id/uhealth_select_cancel").click();
//		driver.findElementByName("ȡ��").click();
		WebElement j = wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.name("����"));
			}
		});
		
		//����
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_personal_center_info_xz").click();
		int xxzStartPoint = ageSelectDialog.getLocation().getX();
		int xxzEndPoint = xxzStartPoint + ageSelectDialog.getSize().getWidth();
		int xxz = (xxzStartPoint+xxzEndPoint)/2;
		
		int yxzStartPoint = ageSelectDialog.getLocation().getY();
		int yxzEndPoint = yxzStartPoint + ageSelectDialog.getSize().getHeight();
		int yxz = (yxzStartPoint+yxzEndPoint)/2;
		
		driver.swipe(xxz, yxz*7/8, xxz, yxz/2, 1000);
		
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_select_ok").click();
//		driver.findElementByName("����").click();
//		driver.findElementById("cn.sccl.ilife.android:id/uhealth_select_cancel").click();
//		driver.findElementByName("ȡ��").click();
		WebElement k = wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.name("����"));
			}
		});
		
		//�޸�Ѫ��
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_personal_center_info_xx").click();
		int xxxStartPoint = ageSelectDialog.getLocation().getX();
		int xxxEndPoint = xxxStartPoint + ageSelectDialog.getSize().getWidth();
		int xxx = (xxxStartPoint+xxxEndPoint)/2;
		
		int yxxStartPoint = ageSelectDialog.getLocation().getY();
		int yxxEndPoint = yxxStartPoint + ageSelectDialog.getSize().getHeight();
		int yxx = (yxxStartPoint+yxxEndPoint)/2;
		
		driver.swipe(xxx, yxx*7/8, xxx, yxx/2, 1000);
		
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_select_ok").click();
//		driver.findElementByName("����").click();
//		driver.findElementById("cn.sccl.ilife.android:id/uhealth_select_cancel").click();
//		driver.findElementByName("ȡ��").click();
		WebElement l = wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.name("����"));
			}
		});
		
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		driver.swipe(width/2, height*7/8, width/2, height/8, 1000);
		
		//�޸�ְҵ   cn.sccl.ilife.android:id/uhealth_lv_city
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_personal_center_info_zy").click();
//		MobileElement hangye_1 = (MobileElement) driver.findElementByAndroidUIAutomator("resourceId(\"cn.sccl.ilife.android:id/uhealth_lv_city\")");
//		MobileElement hangye_2 = (MobileElement) ((FindsByAndroidUIAutomator<WebElement>) hangye_1).findElementByAndroidUIAutomator("text(\"IT������\")");
//		hangye_2.click();
//		MobileElement zhiye_1 = (MobileElement) driver.findElementByAndroidUIAutomator("resourceId(\"cn.sccl.ilife.android:id/uhealth_lv_city\")");
//		MobileElement zhiye_2 = (MobileElement) ((FindsByAndroidUIAutomator<WebElement>) zhiye_1).findElementByAndroidUIAutomator("text(\"���Թ���ʦ\")");
//		zhiye_2.click();
		MobileElement zy = (MobileElement) driver.findElementById("cn.sccl.ilife.android:id/uhealth_lv_city");
		zy.findElementByName("IT������").click();
		zy.findElementByName("���Թ���ʦ").click();
		driver.findElementByName("����").click();
		
//		driver.findElementById("cn.sccl.ilife.android:id/uhealth_base_tv_right").click();
//		driver.findElementById("cn.sccl.ilife.android:id/uhealth_base_iv_back").click();
		WebElement m = wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.name("����"));
			}
		});
		
		//�޸�QQ
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_personal_center_info_qq").click();
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_personal_center_de_iv").click();
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_personal_center_old_info").sendKeys("313371005");
		driver.findElementByName("����").click();
//		driver.findElementById("cn.sccl.ilife.android:id/uhealth_base_tv_right").click();
//		driver.findElementById("cn.sccl.ilife.android:id/uhealth_base_iv_back").click();
		WebElement n = wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.name("����"));
			}
		});
		
		//�޸�΢��
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_personal_center_info_wx").click();
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_personal_center_de_iv").click();
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_personal_center_old_info").sendKeys("��ů�ĸ���");
		driver.findElementByName("����").click();
//		driver.findElementById("cn.sccl.ilife.android:id/uhealth_base_tv_right").click();
//		driver.findElementById("cn.sccl.ilife.android:id/uhealth_base_iv_back").click();
		WebElement o = wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.name("����"));
			}
		});
		
		//�޸���Ȥ����  
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_personal_center_info_ah").click();
		driver.findElementByName("̨��").click();
		driver.findElementByName("��Ӿ").click();
		driver.findElementByName("������").click();
		driver.findElementByName("�ֻ�").click();
		driver.findElementByName("����").click();
		driver.findElementByName("������").click();
		driver.findElementByName("��ɽ").click();
		driver.findElementByName("ɳ����").click();
		driver.findElementByName("����").click();
		WebElement p = wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.name("����"));
			}
		});
//		driver.findElementById("cn.sccl.ilife.android:id/uhealth_base_tv_right").click();
//		driver.findElementById("cn.sccl.ilife.android:id/uhealth_base_iv_back").click();
		//���ظ�������
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_base_iv_back").click();
		
		driver.findElementByName("����").click();
//		//�޸�����
//		driver.findElementByName("�޸�����").click();
//		driver.findElementById("cn.sccl.ilife.android:id/uhealth_personal_center_old_pw").sendKeys("123456");
//		driver.findElementById("cn.sccl.ilife.android:id/uhealth_personal_center_new_pw").sendKeys("111111");
//		driver.findElementById("cn.sccl.ilife.android:id/uhealth_personal_center_new_pw_2").sendKeys("111111");
//		driver.findElementByName("����").click();
//		driver.findElementById("cn.sccl.ilife.android:id/uhealth_base_tv_right").click();
//		driver.findElementById("cn.sccl.ilife.android:id/uhealth_base_iv_back").click();
		//����uker����
		driver.findElementByName("����Uker����").click();
		driver.findElementByName("�汾˵��").click();
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_base_iv_back").click();
		driver.findElementByName("����Э��").click();
		Thread.sleep(2000);
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_base_iv_back").click();
		
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_base_iv_back").click();
		
		//�˳���¼
		driver.findElementByName("�˳���ǰ�˺�").click();
	}
	
	@Test
	/***
	 * ��λ
	 * @param el 
	 * @throws Exception
	 */
	public void b_location() throws Exception{
		
//		driver.findElementByName("δ֪").click();
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_tv_city").click();
//		/***
//		 * ����ѡ��ʡ����
//		 */
//		int width = driver.manage().window().getSize().width;
//		int height = driver.manage().window().getSize().height;
//		driver.swipe(width/2, height*3/4, width/2, height/4, 1000);
//		Thread.sleep(1000);
//		driver.swipe(width/2, height*3/4, width/2, height/4, 1000);
//		Thread.sleep(1000);
//		driver.swipe(width/2, height*3/4, width/2, height/4, 1000);
//		Thread.sleep(1000);
//		driver.findElementByName("�Ĵ�ʡ").click();
//		driver.findElementByName("������").click();
		
		//ͨ������ʡ����λ
		driver.findElementById("android:id/search_src_text").sendKeys("�Ĵ�ʡ");
//		MobileElement lv_city = (MobileElement) driver.findElementByAndroidUIAutomator("resourceId(\"cn.sccl.ilife.android:id/uhealth_lv_city\")");
//		MobileElement shengF = (MobileElement) ((FindsByAndroidUIAutomator<WebElement>) lv_city).findElementByAndroidUIAutomator("text(\"�Ĵ�ʡ\")");
//		shengF.click();
//		MobileElement shi = (MobileElement) ((FindsByAndroidUIAutomator<WebElement>) lv_city).findElementByAndroidUIAutomator("text(\"��֦����\")");
//		shi.click();
		MobileElement location = (MobileElement) driver.findElementById("cn.sccl.ilife.android:id/uhealth_lv_city");
		location.driver.findElementByName("�Ĵ�ʡ").click();
		location.driver.findElementByName("��֦����").click();
	}
	
	@Test
	/***
	 * ������������
	 * resourceId---cn.sccl.ilife.android:id/uhealth_card_pw_patterview
	 * @throws Exception
	 */
	public void c_slideUnlock() throws Exception{
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_tv_card_package").click();
		Thread.sleep(1000);
		/***
		 * Ϊ����Ӧ��ͬ��Ļ�Ļ���������ʵ��˼·��
		 * 1.��ȡ�Ź���patterview����ʼ����x��y
		 * 2.��ȡ�Ź���patterview�Ŀ��(width)���߶�(height)
		 * 3.�Ź���ľŸ����Ӵ�Լƽ����patterview�ĳ�����ƽ���ֳ���4���ȷ֣���ȼ��Ϊwidth/4���߶ȼ��Ϊheight/4
		 * 4.��һ�����ӵ�����Ϊ��x+width/4, y+height/4��
		 * 5.ʹ��TouchAction��moveTo����ʵ�ֻ�������
		 */
		WebElement patterview = driver.findElementById("cn.sccl.ilife.android:id/uhealth_card_pw_patterview");
		//��ȡ�ؼ���ʼ�����x��y
		int xStartPoint = patterview.getLocation().getX();
		int yStartPoint = patterview.getLocation().getY();
		//��ȡ�ؼ��ĸ߶ȡ����
		int width = patterview.getSize().getWidth();
		int height = patterview.getSize().getHeight();
		//��ȡ��߶�֮��ļ��
		int xStep = width/4;
		int yStep = height/4;
		//patterview��ʼ�����x��y����һ��������ؼ���ʼ�������һ�����
		int x = xStartPoint + xStep;  
		int y = yStartPoint + yStep;
		
		TouchAction slide = new TouchAction(driver).press(x, y).waitAction(500).moveTo(0, yStep).waitAction(500).moveTo(0, yStep).waitAction(500)
				.moveTo(xStep, 0).release();
		slide.perform();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement e = wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.name("�󶨿�"));
			}
		});
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_base_iv_back").click();
	}
	
	@Test
	/***
	 * �鿴����������
	 * @throws Exception
	 */
	public void d_JianKangKa() throws Exception{
		driver.findElementByName("������").click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement e = wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.className("android.widget.ListView"));
			}
		});
	}
	
	@Test
	/***
	 * �鿴������¼
	 * @throws Exception
	 */
	public void e_JianKangJiLu() throws Exception{
		driver.findElementByName("������¼").click();
		Thread.sleep(1000);
//		driver.findElementByName("ȫ��").click();
//		Thread.sleep(1000);
		driver.findElementByName("�Һž�ҽ").click();
		Thread.sleep(1000);
		driver.findElementByName("���").click();
		Thread.sleep(1000);
		driver.findElementByName("�˶�").click();
		Thread.sleep(1000);
	}
	
	public void f_help() throws Exception{
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_tv_me").click();
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_me_help_rl").click();
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_personal_center_help_text").sendKeys("���գ����ҷ�չ�ĸ�ί��������Դ�֡���������ʮ�岿������ӡ����"
				+ "��������������ȼ���Ҵ��������ƹ�ʹ�ó����Ҵ����͵�ʵʩ��������");
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_personal_center_help_time").click();
		MobileElement datePicker = (MobileElement) driver.findElementById("cn.sccl.ilife.android:id/dateAndTimePicker_datePicker");  //��ȡ�����յĿؼ�
		MobileElement timePicker = (MobileElement) driver.findElementById("cn.sccl.ilife.android:id/dateAndTimePicker_timePicker");  //��ȡСʱ���ӵĿؼ�
		int xDateStartPoint = datePicker.getLocation().getX();
		int yDateStartPoint = datePicker.getLocation().getY();
		int widhtDate = datePicker.getSize().width;
		int heightDate = datePicker.getSize().height;
		//���������ջ���������
		int x1DateEndPoint = (xDateStartPoint + widhtDate*1/4);
		int y1DateEndPoint = (yDateStartPoint + heightDate*1/4);
		
		int x2DateEndPoint = (xDateStartPoint + widhtDate*2/4);
		int y2DateEndPoint = (yDateStartPoint + heightDate*2/4);
		
		int x3DateEndPoint = (xDateStartPoint + widhtDate*3/4);
		int y3DateEndPoint = (yDateStartPoint + heightDate*3/4);
		
		int xTimeStartPoint = timePicker.getLocation().getX();
		int yTimeStartPoint = timePicker.getLocation().getY();
		int widthTime = timePicker.getSize().width;
		int heightTime = timePicker.getSize().height;
		//����Сʱ���ӻ���������
		int x1TimeEndPoint = (xTimeStartPoint + widthTime*1/3);
		int y1TimeEndPoint = (yTimeStartPoint + heightTime*1/3);
		
		int x2TimeEndPoint = (xTimeStartPoint + widthTime*2/3);
		int y2TimeEndPoint = (yTimeStartPoint + heightTime*2/3);
		
		driver.swipe(x1DateEndPoint, y1DateEndPoint, x1DateEndPoint, y3DateEndPoint, 1000);  //ѡ����
		Thread.sleep(1000);
		driver.swipe(x2DateEndPoint, y1DateEndPoint, x2DateEndPoint, y3DateEndPoint, 1000);  //ѡ����
		Thread.sleep(1000);
		driver.swipe(x3DateEndPoint, y1DateEndPoint, x3DateEndPoint, y3DateEndPoint, 1000);  //ѡ����
		Thread.sleep(1000);
		
		driver.swipe(x1TimeEndPoint, y1TimeEndPoint, x1TimeEndPoint, y2TimeEndPoint, 1000);  //ѡ��Сʱ
		Thread.sleep(1000);
		driver.swipe(x2TimeEndPoint, y1TimeEndPoint, x2TimeEndPoint, y2TimeEndPoint, 1000);  //ѡ�����
		Thread.sleep(1000);
		
		driver.findElementById("android:id/button1").click();
		Thread.sleep(1000);
		driver.findElementById("cn.sccl.ilife.android:id/uhealth_personal_center_help_btn").click();
		Thread.sleep(1000);
	}
	
	@AfterSuite
	public void tearDown() throws Exception{
		driver.quit();
	}
}
