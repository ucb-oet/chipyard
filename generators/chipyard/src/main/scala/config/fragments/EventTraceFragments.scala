package chipyard.config

import org.chipsalliance.cde.config.{Config, Field}

/** Whether the design's EventTrace annotations elaborate. Off unless a config adds [[WithEventTrace]], so generators
  * can carry annotations at no cost to builds that do not trace.
  */
case object EventTraceKey extends Field[Boolean](false)

/** Elaborates the design's EventTrace annotations: their capture sinks, the runtime they compile into the simulator,
  * and `<long_name>.eventtrace.json`, which describes the traced events. A simulation run with `+eventtrace=<path>`
  * writes its records to that file.
  */
class WithEventTrace extends Config((site, here, up) => {
  case EventTraceKey => true
})
