<img width="178" alt="image" src="https://github.com/user-attachments/assets/77394e99-6d1f-479e-9162-8fb16880c629" />
<img width="206" alt="image" src="https://github.com/user-attachments/assets/9525c4a0-0e36-46a0-a190-0090b71dd28f" />
<img width="185" alt="image" src="https://github.com/user-attachments/assets/880873e2-0a8a-4b4f-8e31-c2142bc98f05" />


I am using android studio (Android Studio Meerkat Feature Drop | 2024.3.2) with kotlin while i am using WSL so my emulator not working
hence i am using docker-android with below command and its working fine for me.
docker run -d \
  --privileged \
  -p 6080:6080 \
  -p 5555:5555 \
  -p 5037:5037 \
  -e EMULATOR_DEVICE="Samsung Galaxy S10" \
  -e WEB_VNC=true \
  -e ADB_SERVER_PORT=5037 \
  --device /dev/kvm \
  --name android-container \
  budtmo/docker-android:emulator_14.0

adb connect 127.0.0.1:5555

  export ADB_SERVER_SOCKET=tcp:127.0.0.1:5037

docker inspect android-container | grep IPAddress
