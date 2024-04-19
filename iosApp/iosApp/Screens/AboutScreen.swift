
import SwiftUI

struct AboutScreen: View {
    @Environment(\.dimmiss)
    private var dismiss

    var body:some View {
        NavigationStack {
            AboutListView()
            .navigationTitle("About Device")
            .toolbar {
                ToolbarItem(placement: primaryAction) {
                    Button {
                        dismiss()
                    } label: {
                        Text("Done").bold()
                    }
                }
            }
        }
    }
}

#Preview {
    AboutScreen()
}