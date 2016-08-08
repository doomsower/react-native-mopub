import React, {Component} from 'react';
import {StyleSheet, View, Platform} from 'react-native';
import Button from 'apsl-react-native-button';
import {MoPubBanner, MoPubInterstitial} from 'react-native-mopub';

const INTERSTITIAL_UNIT_ID = Platform.OS == 'ios' ? '4f117153f5c24fa6a3a92b818a5eb630' : '24534e1901884e398f1253216226017e'; 
const BANNERL_UNIT_ID = Platform.OS == 'ios' ? '0ac59b0996d947309c33f59d6676399f' : 'b195f8dd8ded45fe847ad89ed1d016da'; 


export default class App extends Component {

  componentWillMount() {
    MoPubInterstitial.initialize(INTERSTITIAL_UNIT_ID);
    //MoPubInterstitial.setTesting(true);
    MoPubInterstitial.addEventListener('onLoaded', () => console.log('Interstitial loaded'));
    MoPubInterstitial.addEventListener('onFailed', message => console.log('Interstitial failed: ' + message));
    MoPubInterstitial.addEventListener('onClicked', () => console.log('Interstitial clicked'));
    MoPubInterstitial.addEventListener('onShown', () => console.log('Interstitial shown'));
    MoPubInterstitial.addEventListener('onDismissed', () => console.log('Interstitial dismissed'));
  }

  componentWillUnmount() {
    MoPubInterstitial.removeAllListeners('onLoaded');
    MoPubInterstitial.removeAllListeners('onFailed');
    MoPubInterstitial.removeAllListeners('onClicked');
    MoPubInterstitial.removeAllListeners('onShown');
    MoPubInterstitial.removeAllListeners('onDismissed');
  }

  render() {
    return (
      <View style={styles.content}>
        <MoPubBanner 
          adUnitId={BANNERL_UNIT_ID}
          autoRefresh={true}
          onLoaded={this.onLoaded}
          onFailed={this.onFailed}
          onClicked={this.onClicked}
          onExpanded={this.onExpanded}
          onCollapsed={this.onCollapsed}
        />
        <Button style={styles.button} onPress={this.onPress}>Show interstitial</Button>
      </View>
    );
  }

  onPress = () => {
    MoPubInterstitial.showWhenReady();
  };

  onLoaded = () => {
    console.log('MoPub banner loaded');
  };

  onFailed = message => {
    console.log('MoPub banner failed with message: ' + message);
  };

  onClicked = () => {
    console.log('MoPub banner was clicked');
  };

  onExpanded = () => {
    console.log('MoPub banner was expanded');
  };

  onCollapsed = () => {
    console.log('MoPub banner was collapsed');
  };

}

const styles = StyleSheet.create({
  content: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  button: {
    margin: 16,
    backgroundColor: 'teal',
    borderWidth: 0
  }
});