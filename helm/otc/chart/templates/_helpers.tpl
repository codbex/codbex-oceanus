{{- define "booleanToStringValue" -}}
{{- if eq (typeOf .value) "bool" -}}
  {{- if .value }}true{{- else }}false{{- end }}
{{- else -}}
  {{- if eq (toString .value | lower) "true" }}true{{- else }}false{{- end }}
{{- end -}}
{{- end -}}
