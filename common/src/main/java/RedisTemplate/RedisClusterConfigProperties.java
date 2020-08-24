package RedisTemplate;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.redis.cluster")

public class RedisClusterConfigProperties {
    private List<String> nodes;
    private Integer maxAttempts;
    private Integer connectionTimeout;
    private Integer soTimeout;
    private String password;
	public List<String> getNodes() {
		return nodes;
	}
	public void setNodes(List<String> nodes) {
		this.nodes = nodes;
	}
	public Integer getMaxAttempts() {
		return maxAttempts;
	}
	public void setMaxAttempts(Integer maxAttempts) {
		this.maxAttempts = maxAttempts;
	}
	public Integer getConnectionTimeout() {
		return connectionTimeout;
	}
	public void setConnectionTimeout(Integer connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}
	public Integer getSoTimeout() {
		return soTimeout;
	}
	public void setSoTimeout(Integer soTimeout) {
		this.soTimeout = soTimeout;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    
}