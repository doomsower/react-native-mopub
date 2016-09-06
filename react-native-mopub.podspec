Pod::Spec.new do |s|
  s.name             = 'react-native-mopub'
  s.version          = '0.1.0'
  s.summary          = 'A React Native module that wraps MoPub SDK'
  s.requires_arc = true
  s.homepage         = 'https://github.com/doomsower/react-native-mopub'
  s.license          = { :type => 'MIT', :file => 'LICENSE' }
  s.author           = { 'Konstantin Kuznetsov' => 'K.Kuznetcov@gmail.com' }
  s.source           = { :git => 'https://github.com/doomsower/react-native-mopub.git', :tag => s.version.to_s }

  s.source_files = 'ios/*.{h,m}'

  s.platform     = :ios, "7.0"

  s.dependency 'React'
  s.dependency 'mopub-ios-sdk'
end
