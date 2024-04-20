import SwiftUI
import shared

@main
struct iOSApp: App {

    init(){
        KoinInitializerkt.doInitKoin()
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}