import common.config.Platform
import org.koin.core.module.Module

expect fun getPlatformName(): Platform
expect fun platformModule(): Module