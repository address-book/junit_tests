run_all_in_parallel:
	make clean_it test_parallel

clean_it:
	mvn clean

test_parallel:
	make -j win_10_ff win_10_chrome win_10_edge windows_8_ie mac_sierra_chrome windows_7_ff mac_sierra_ff

win_10_ff:
	mvn install -DPLATFORM=win_10_ff

win_10_chrome:
	mvn install -DPLATFORM=win_10_chrome

win_10_edge:
	mvn install -DPLATFORM=win_10_edge

windows_8_ie:
	mvn install -DPLATFORM=windows_8_ie

mac_sierra_chrome:
	mvn install -DPLATFORM=mac_sierra_chrome

windows_7_ff:
	mvn install -DPLATFORM=windows_7_ff

mac_sierra_ff:
	mvn install -DPLATFORM=mac_sierra_ff

