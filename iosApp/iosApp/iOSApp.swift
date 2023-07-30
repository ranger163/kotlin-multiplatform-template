import SwiftUI
import shared

@main
struct iosApp: App {
    
    init(){
        KoinKt.doInitKoin(enableNetworkLogs: true) // Pass true/false depending on debug/release config
    }
    
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
