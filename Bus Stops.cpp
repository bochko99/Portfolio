#include <iostream>
#include <string>
#include <map>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
  int q;
  cin >> q;

  map<int, vector<string> > stops;

  for (int i = 0; i < q; ++i) {

    string operation_code;
    cin >> operation_code;

    if (operation_code == "NEW_BUS"){
    	int bus, n_stops;
    	cin >> bus >> n_stops;
    	vector<string> stops_for;
    	string stop;
    	for (int j = 0; j < n_stops; j++){
    		cin >> stop;
    		stops_for.push_back(stop);
    	}
    	stops[bus] = stops_for;
    }
    if (operation_code == "BUSES_FOR_STOP"){
        string stop;
        cin >> stop;
        bool exist = false;
        for (const auto& a: stops){
        	for (const auto& every_stop: a.second){
        		if (every_stop == stop){
        			cout << a.first << " ";
        			exist = true;
        		}
        	}
      	}
        if (!exist){
        	cout << "No stop" << endl;
        }
    }
    if (operation_code == "STOPS_FOR_BUS"){
    	int busnum;
    	cin >> busnum;
    	for (const auto& st: stops[busnum]){
    		cout << st << " " << endl;
    		bool interchange;
    		for (const auto& a: stops){
    		   for (const auto& every_stop: a.second){
    			   if (every_stop == st){
    				   cout << a.first << " ";
    				   interchange = true;
    		       }
    		   }
    		}
    		if (!interchange){
    			cout << "No interchange" << endl;
    		}
    	}
    }
    if (operation_code == "ALL_BUSES"){
    	for (const auto& bus: stops){
    		cout << bus.first;
    		for (const auto& st: bus.second){
    			cout << st << " ";
    		}
    		cout << endl;
    	}
    }
  }

  return 0;
}
