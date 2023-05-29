import SwiftUI
import shared

@main
struct iosApp: App {
    
    init(){
        KoinKt.doInitKoin(enableNetworkLogs: true)
    }
    
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
