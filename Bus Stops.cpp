#include <iostream>
#include <string>
#include <map>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int q;
	cin >> q;

	map<string, vector<string> > stops_for_buses;
	map<string, vector<string> > buses_for_stops;

	for (int i = 0; i < q; ++i) {

		string operation_code;
		cin >> operation_code;

		if (operation_code == "NEW_BUS") {
			int n_stops;
			string busnum;
			cin >> busnum >> n_stops;
			vector<string> stops_for_bus;
			string stop;
			for (int j = 0; j < n_stops; j++){
				cin >> stop;
				stops_for_buses[busnum].push_back(stop);
				buses_for_stops[stop].push_back(busnum);
			}
		}
		if (operation_code == "BUSES_FOR_STOP") {
			string stop;
			cin >> stop;
			if (buses_for_stops.count(stop)>0){
				for (auto a: buses_for_stops[stop]){
					cout << a << " ";
				}
				cout << endl;
			} else {
				cout << "No stop" << endl;
			}
		}
		if (operation_code == "STOPS_FOR_BUS") {
			string busnum;
			cin >> busnum;
			if (stops_for_buses.count(busnum) > 0){
			for (auto a: stops_for_buses[busnum]){
				cout << "Stop " << a << ": ";
				bool interch = false;
					for (auto b: buses_for_stops[a]){
						if (b != busnum){
							cout << b << " ";
							interch = true;
						}
					}
				if (!interch){
					cout << "no interchange" << endl;
				} else {
					cout << endl;
				}
			}
			} else {
				cout << "No bus" << endl;
			}
		}
		if (operation_code == "ALL_BUSES") {
			bool no_buses = true;
			for (auto b: stops_for_buses){
				cout << "Bus " << b.first << ": ";
				no_buses = false;
				for (auto s: b.second){
					cout << s << " ";
				}
				cout << endl;
			}
			if (no_buses){
				cout << "No buses" << endl;
			}
		}
	}
	return 0;
}
