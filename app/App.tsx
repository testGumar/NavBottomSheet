import {
  Button,
  NativeModules,
  SafeAreaView,
  ScrollView,
  StatusBar,
  StyleSheet,
  Text,
  useColorScheme,
  View,
} from 'react-native';

import {
  Colors,
  DebugInstructions,
  Header,
  ReloadInstructions,
} from 'react-native/Libraries/NewAppScreen';

// function App(): React.JSX.Element {
const App = (props: any): JSX.Element => {
  const isDarkMode = useColorScheme() === 'dark';
  const { username, userId } = props;

  const backgroundStyle = {
    backgroundColor: isDarkMode ? Colors.darker : Colors.lighter,
  };

   // ✨ Add your click handler
  const handlePress = () => {
    // Alert.alert('Hello!', `Hey ${username}, your ID is ${userId}`);
    NativeModules.MyDataReceiver.sendDataToNative({ msg: "Bridge operational, captain! 🚀", timestamp: Date.now() });
  };

  return (
    <SafeAreaView style={backgroundStyle}>
      <StatusBar
        barStyle={isDarkMode ? 'light-content' : 'dark-content'}
        backgroundColor={backgroundStyle.backgroundColor}
      />
      <ScrollView
        contentInsetAdjustmentBehavior="automatic"
        style={backgroundStyle}>
        <Header />
        <View
          style={{
            backgroundColor: isDarkMode
              ? Colors.black
              : Colors.white,
            padding: 24,
          }}>
          <Text style={styles.title}>Step One Umar Sayed</Text>
          <Text>
            Edit <Text style={styles.bold}>App.tsx</Text> to
            change this screen and see your edits.
          </Text>
          <Text style={styles.title}>See your changes</Text>
          <ReloadInstructions />
          <Text style={styles.title}>Debug</Text>
          <Text>Welcome, <Text style={styles.bold}>{username}!</Text></Text>
          <Text>Your user ID is <Text style={styles.bold}>{userId}</Text></Text>
          <DebugInstructions />

           {/* ✨ Add the button here */}
          <View style={{ marginTop: 20 }}>
            <Button title="Click Me" onPress={handlePress} />
          </View>
        </View>
      </ScrollView>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  title: {
    fontSize: 24,
    fontWeight: '600',
  },
  bold: {
    fontWeight: '700',
  },
});

export default App;