import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.wahlzeit.handlers.TellFriendTest;
import org.wahlzeit.model.AccessRightsTest;
import org.wahlzeit.model.FlagReasonTest;
import org.wahlzeit.model.GenderTest;
import org.wahlzeit.model.GuestTest;
import org.wahlzeit.model.JapanManagerTest;
import org.wahlzeit.model.PhotoFilterTest;
import org.wahlzeit.model.JapanPhotoTest;
import org.wahlzeit.model.JapanTest;
import org.wahlzeit.model.JapanTypeTest;
import org.wahlzeit.model.JapanPhotoManagerTest;
import org.wahlzeit.model.JapanPhotoFactoryTest;
import org.wahlzeit.model.TagsTest;
import org.wahlzeit.model.UserStatusTest;
import org.wahlzeit.model.ValueTest;
import org.wahlzeit.model.persistence.AbstractAdapterTest;
import org.wahlzeit.model.persistence.DatastoreAdapterTest;
import org.wahlzeit.services.EmailAddressTest;
import org.wahlzeit.services.LogBuilderTest;
import org.wahlzeit.services.mailing.EmailServiceTest;
import org.wahlzeit.utils.StringUtilTest;
import org.wahlzeit.utils.VersionTest;

@RunWith(Suite.class)
@SuiteClasses({TellFriendTest.class, 
	AccessRightsTest.class,
	FlagReasonTest.class,
	GenderTest.class,
	GuestTest.class,
	DatastoreAdapterTest.class,
	PhotoFilterTest.class,
	JapanPhotoTest.class,
	JapanPhotoManagerTest.class,
	JapanPhotoFactoryTest.class,
	JapanManagerTest.class,
	JapanTest.class,
	JapanTypeTest.class,
	TagsTest.class,
	UserStatusTest.class,
	ValueTest.class,
	EmailAddressTest.class,
	LogBuilderTest.class,
	EmailServiceTest.class,
	StringUtilTest.class,
	VersionTest.class})
public class AllTests {

}
